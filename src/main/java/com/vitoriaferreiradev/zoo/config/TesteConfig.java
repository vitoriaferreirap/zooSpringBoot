package com.vitoriaferreiradev.zoo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.entities.Habitat;
import com.vitoriaferreiradev.zoo.entities.enums.Presenca;
import com.vitoriaferreiradev.zoo.repositories.AnimalRepository;
import com.vitoriaferreiradev.zoo.repositories.HabitatRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    // injeção de dependência
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private HabitatRepository habitatRepository;

    private Habitat getOrCreateHabitat(String nome, List<Habitat> habitatsExistentes) {
        Habitat habitat = new Habitat(null, nome);

        // expressao lambda para verificar se o habitat já existe
        if (habitatsExistentes.stream().noneMatch(h -> h.getNome().equals(nome))) {
            return habitatRepository.save(habitat);
        }

        return habitatsExistentes.stream()
                .filter(h -> h.getNome().equals(nome))
                .findFirst()
                .get();
    }

    private Animal getOrCreateAnimal(String nome, String categoria, String dieta, Presenca presenca, Habitat habitat) {
        /*
         * Em um zoológico:
         * Dois animais diferentes podem ter nomes diferentes mas serem da mesma
         * categoria;
         * Podem ter o mesmo nome mas serem de categorias diferentes;
         * NÃO podem ter o mesmo nome e a mesma categoria;
         */
        List<Animal> animaisExistentes = animalRepository.findAll();

        Animal animal = new Animal(null, nome, categoria, dieta, presenca, habitat);

        // Verifica se já existe um animal com esse nome && categoria
        if (animaisExistentes.stream().noneMatch(a -> a.getNome().equals(nome) &&
                a.getCategoria().equals(categoria))) {
            return animalRepository.save(animal);
        }

        // Se existir, retorna o animal encontrado
        return animaisExistentes.stream()
                .filter(a -> a.getNome().equals(nome) &&
                        a.getCategoria().equals(categoria))
                .findFirst()
                .get();
    }

    @Override
    public void run(String... args) throws Exception {
        // Recupera todos os habitats existentes no banco
        List<Habitat> habitatsExistentes = habitatRepository.findAll();

        // Obtém ou cria os habitats necessários
        Habitat floresta = getOrCreateHabitat("Floresta", habitatsExistentes);
        Habitat savana = getOrCreateHabitat("Savana", habitatsExistentes);
        Habitat aquatico = getOrCreateHabitat("Aquatico", habitatsExistentes);

        // Obtém ou cria os animais com os habitats corretos
        getOrCreateAnimal("Moli", "Tartaruga", "Herbívora", Presenca.PRESENTE, aquatico);
        getOrCreateAnimal("Bob", "Leão", "Carnivoro", Presenca.AUSENTE, savana);
        getOrCreateAnimal("Lili", "Macaco", "Onívoro", Presenca.PRESENTE, floresta);

        // TESTE MESMO NOME E CATEGORIA
        getOrCreateAnimal("Moli", "Tartaruga", "Herbívora", Presenca.PRESENTE, aquatico);

        // TESTE MESMO NOME MAS CATEGORIA DIFERENTE
        getOrCreateAnimal("Moli", "Macaco", "Onívoro", Presenca.PRESENTE, floresta);

        // TESTE NOME NOVO EM CATEGORIA EXISTENTE
        getOrCreateAnimal("Bob", "Macaco", "Onívoro", Presenca.PRESENTE, floresta);
    }

}
