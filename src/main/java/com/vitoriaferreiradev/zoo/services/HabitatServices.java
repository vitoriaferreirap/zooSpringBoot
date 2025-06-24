package com.vitoriaferreiradev.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoriaferreiradev.zoo.entities.Habitat;
import com.vitoriaferreiradev.zoo.repositories.HabitatRepository;

@Service
public class HabitatServices {

    @Autowired
    private HabitatRepository habitatRepository;

    public List<Habitat> listarHabitats() {
        return habitatRepository.findAll();
    }
}
