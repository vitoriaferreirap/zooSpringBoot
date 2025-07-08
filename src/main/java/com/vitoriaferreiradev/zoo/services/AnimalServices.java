package com.vitoriaferreiradev.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.repositories.AnimalRepository;

@Service
public class AnimalServices {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> linstarAnimais() {
        return animalRepository.findAll();
    }

    // find by id
    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
    }

    // insert
    public Animal inserir(Animal animal) {
        return animalRepository.save(animal);
    }

    // update
    public Animal update(Long id, Animal animal) {
        Animal entity = findById(id);
        updateDate(entity, animal);
        return animalRepository.save(entity);
    }

    private void updateDate(Animal entity, Animal animal) {
        entity.setNome(animal.getNome());
        entity.setCategoria(animal.getCategoria());
        entity.setDieta(animal.getDieta());
        entity.setPresenca(animal.getPresenca());
        entity.setHabitat(animal.getHabitat());
    }
}