package com.vitoriaferreiradev.zoo.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.repositories.AnimalRepository;

@Service
public class AnimalServices {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> linstarAnimais() {
        return animalRepository.findAll();
    }
}