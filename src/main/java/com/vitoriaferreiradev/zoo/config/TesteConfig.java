package com.vitoriaferreiradev.zoo.config;

import java.util.Arrays;

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

    @Override
    public void run(String... args) throws Exception {

        // criação de habitats e animais para testes
        Habitat habitat1 = new Habitat(null, "Floresta");
        Habitat habitat2 = new Habitat(null, "Savana");
        Habitat habitat3 = new Habitat(null, "Aguatico");

        Animal animal1 = new Animal(null, "Moli", "Tartaruga", "Herbívora", Presenca.PRESENTE);
        Animal animal2 = new Animal(null, "Bob", "Leão", "Carnivoro", Presenca.AUSENTE);

        // salvando os habitats e animais no banco de dados
        habitatRepository.saveAll(Arrays.asList(habitat1, habitat2, habitat3));
        animalRepository.saveAll(Arrays.asList(animal1, animal2));

        // associando o animal ao habitat
        animal1.setHabitat(habitat1);
        animal2.setHabitat(habitat2);

        // salvando o animal novamente para atualizar a associação
        animalRepository.save(animal1);
        animalRepository.save(animal2);
    }

}
