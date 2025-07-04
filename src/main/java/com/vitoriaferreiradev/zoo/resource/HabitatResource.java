package com.vitoriaferreiradev.zoo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vitoriaferreiradev.zoo.entities.Habitat;
import com.vitoriaferreiradev.zoo.services.HabitatServices;

@RestController
@RequestMapping(value = "/habitat")
public class HabitatResource {

    @Autowired
    private HabitatServices habitatServices;

    @GetMapping
    public ResponseEntity<List<Habitat>> listarHabitats() {
        List<Habitat> lista = habitatServices.listarHabitats();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<Habitat> insert(@RequestBody Habitat obj) {
        obj = habitatServices.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
