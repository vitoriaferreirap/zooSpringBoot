package com.vitoriaferreiradev.zoo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
