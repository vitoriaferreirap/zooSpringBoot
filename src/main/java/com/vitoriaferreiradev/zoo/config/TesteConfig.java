package com.vitoriaferreiradev.zoo.config;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.entities.Habitat;
import com.vitoriaferreiradev.zoo.entities.enums.Presenca;
import com.vitoriaferreiradev.zoo.repositories.AnimalRepository;
import com.vitoriaferreiradev.zoo.repositories.HabitatRepository;
import com.vitoriaferreiradev.zoo.services.exceptions.DuplicatedAnimalException;
import com.vitoriaferreiradev.zoo.services.exceptions.InvalidDataException;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    // injeção de dependência
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private HabitatRepository habitatRepository;

    private Habitat getOrCreateHabitat(String nomeHabitat, List<Habitat> habitatsExistentes) {

        // Valida se só tem letras e espaços (ou só letras se quiser)
        if (!soTemLetras(nomeHabitat)) {
            throw new InvalidDataException("Nome do habitat deve conter apenas letras e espaços.");
        }

        Habitat habitat = new Habitat(null, nomeHabitat);

        // Verifica se já existe um habitat com esse nome
        if (habitatsExistentes.stream().noneMatch(h -> h.getNome().equals(nomeHabitat))) {
            return habitatRepository.save(habitat);
        }

        return habitatsExistentes.stream()
                .filter(h -> h.getNome().equals(nomeHabitat))
                .findFirst()
                .get();
    }

    // Função auxiliar para validar entradas string
    public static boolean soTemLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private Animal getOrCreateAnimal(String nomeAnimal, String categoriaAnimal, String dietaAnimal,
            Presenca presencaAnimal, Habitat habitatAnimal) {
        /*
         * Validação de regra de negócio: Não indica necessariamente um erro, apenas um
         * fluxo alternativo
         * Dois animais diferentes podem ter nomes diferentes mas serem da mesma
         * categoria;
         * Podem ter o mesmo nome mas serem de categorias diferentes;
         * NÃO podem ter o mesmo nome e a mesma categoria;
         */

        // Validações com exceções - situações que não devem acontecer
        if (habitatAnimal == null) {
            throw new InvalidDataException("Habitat do animal é obrigatorio");
        }
        if (nomeAnimal == null || nomeAnimal.trim().isEmpty()) {
            throw new InvalidDataException("Nome do animal é obrigatorio");
        }
        if (!soTemLetras(nomeAnimal)) {
            throw new InvalidDataException("Nome do animal deve conter apenas letras.");
        }
        if (categoriaAnimal == null || categoriaAnimal.trim().isEmpty()) {
            throw new InvalidDataException("Categoria do animal é obrigatória.");
        }
        if (!soTemLetras(categoriaAnimal)) {
            throw new InvalidDataException("Categoria do animal deve conter apenas letras.");
        }
        if (dietaAnimal == null || dietaAnimal.trim().isEmpty()) {
            throw new InvalidDataException("Dieta do animal é obrigatória.");
        }
        if (!soTemLetras(dietaAnimal)) {
            throw new InvalidDataException("Dieta do animal deve conter apenas letras.");
        }

        List<Animal> animaisExistentes = animalRepository.findAll();

        Animal animal = new Animal(null, nomeAnimal, categoriaAnimal, dietaAnimal, presencaAnimal, habitatAnimal);

        // Verifica se já existe um animal com esse nome && categoria
        // Validações com exceções - situações que não devem acontecer
        if (animaisExistentes.stream().noneMatch(a -> a.getNome().equals(nomeAnimal) &&
                a.getCategoria().equalsIgnoreCase(categoriaAnimal))) {
            return animalRepository.save(animal);
        }
        throw new DuplicatedAnimalException(
                "Animal já existe.");
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Iniciando configuração de teste...");
            System.err.println("Escolha uma opçao: ");
            System.out.println("1. Inserir habitats");
            System.out.println("2. Inserir animais");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            if (opcao <= 0 || opcao > 3) {
                throw new InvalidDataException("Opção inválida.");
            }
            // Recupera todos os habitats existentes no banco
            List<Habitat> habitatsExistentes = habitatRepository.findAll();
            switch (opcao) {
                case 1:

                    try {
                        System.out.println("Inserindo habitats...");
                        System.out.println("Digite o nome do habitat: ");

                        String nomeHabitat = scanner.nextLine().toUpperCase();
                        getOrCreateHabitat(nomeHabitat, habitatsExistentes);
                    } catch (InputMismatchException e) {
                        System.out.println("\n Erro: " + e.getMessage());
                        break;
                    }
                case 2:
                    boolean animalValido = false;
                    while (!animalValido) {
                        try {
                            System.out.println("Inserindo animais...");

                            System.out.print("Digite o nome do animal: ");
                            String nomeAnimal = scanner.nextLine().trim();

                            System.out.print("Digite a categoria do animal: ");
                            String categoriaAnimal = scanner.nextLine().trim().toUpperCase();

                            System.out.print("Digite a dieta do animal: ");
                            String dietaAnimal = scanner.nextLine().trim().toUpperCase();

                            System.out.print("Digite a presença do animal (PRESENTE/AUSENTE): ");
                            String presencaInput = scanner.nextLine().trim().toUpperCase();
                            Presenca presencaAnimal = Presenca.valueOf(presencaInput);

                            System.out.print("Digite o nome do habitat do animal: ");
                            String nomeHabitatAnimal = scanner.nextLine().trim().toUpperCase();

                            Habitat habitatAnimal = getOrCreateHabitat(nomeHabitatAnimal, habitatsExistentes);

                            getOrCreateAnimal(nomeAnimal, categoriaAnimal, dietaAnimal, presencaAnimal, habitatAnimal);

                            System.out.println("Animal inserido com sucesso!");
                            animalValido = true;

                        } catch (InputMismatchException e) {
                            System.out.println("Erro de entrada: " + e.getMessage());
                            scanner.nextLine(); // limpar buffer, se necessário
                        } catch (InvalidDataException e) {
                            System.out.println("Erro de validação: " + e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Erro: valor inválido para presença. Use PRESENTE ou AUSENTE.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                default:
                    System.out.println("Opção inválida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite apenas números!");
            return;
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
            return; // Encerra o método se a entrada for inválida
        }

        scanner.close();

    }

}
