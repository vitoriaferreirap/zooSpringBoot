package com.vitoriaferreiradev.zoo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.entities.enums.Presenca;
import com.vitoriaferreiradev.zoo.repositories.AnimalRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    // injeção de dependência
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public void run(String... args) throws Exception {

        Animal animal1 = new Animal(null, "Moli", "Tartaruga", "herbívora", Presenca.PRESENTE);
        animalRepository.saveAll(Arrays.asList(animal1));
    }

}
