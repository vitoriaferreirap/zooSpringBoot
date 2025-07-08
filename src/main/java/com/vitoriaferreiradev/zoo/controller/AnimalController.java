package com.vitoriaferreiradev.zoo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.services.AnimalServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/animais") // mapeamento de recursos para todos os endpoints deste controller
public class AnimalController {

    // AnimalResource depende do AnimalService
    @Autowired
    private AnimalServices animalServices;

    // endpoints - encapsulamento de recursos (respostas http)
    @GetMapping
    public ResponseEntity<List<Animal>> linstarAnimais() {
        List<Animal> lista = animalServices.linstarAnimais();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Animal> insert(@Valid @RequestBody Animal obj) {
        obj = animalServices.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @Valid @RequestBody Animal animal) {
        animal = animalServices.update(id, animal);
        return ResponseEntity.ok().body(animal);
    }
}
