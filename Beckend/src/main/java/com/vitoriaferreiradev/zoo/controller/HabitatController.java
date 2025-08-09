package com.vitoriaferreiradev.zoo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoriaferreiradev.zoo.entities.Habitat;
import com.vitoriaferreiradev.zoo.services.HabitatServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/habitats")
public class HabitatController {

    @Autowired
    private HabitatServices habitatServices;

    @GetMapping
    public ResponseEntity<List<Habitat>> listarHabitats() {
        List<Habitat> lista = habitatServices.listarHabitats();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Habitat> insert(@Valid @RequestBody Habitat obj) {
        obj = habitatServices.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> update(@PathVariable Long id, @Valid @RequestBody Habitat habitat) {
        habitat = habitatServices.update(id, habitat);
        return ResponseEntity.ok().body(habitat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habitatServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
