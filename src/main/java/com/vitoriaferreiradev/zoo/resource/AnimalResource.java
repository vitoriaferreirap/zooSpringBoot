package com.vitoriaferreiradev.zoo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.services.AnimalServices;

@RestController
@RequestMapping(value = "/animal")
public class AnimalResource {

    // AnimalResource depende do AnimalService
    @Autowired
    private AnimalServices animalServices;

    // endpoints - encapsulamento de recursos (respostas http)
    @GetMapping
    public ResponseEntity<List<Animal>> linstarAnimais() {
        List<Animal> lista = animalServices.linstarAnimais();
        return ResponseEntity.ok().body(lista);
    }
}
