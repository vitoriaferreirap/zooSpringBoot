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

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.services.AnimalServices;

import jakarta.validation.Valid;

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

    /*
     * O padrão REST recomenda que, ao criar um novo recurso (POST), a resposta deve
     * conter o status 201 Created e o cabeçalho Location com a URL do novo recurso.
     * por esse motivo cria-se a URL
     */

    @PostMapping
    public ResponseEntity<Animal> insert(@Valid @RequestBody Animal obj) {
        obj = animalServices.inserir(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
