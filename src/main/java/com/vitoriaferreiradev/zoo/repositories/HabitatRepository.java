package com.vitoriaferreiradev.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreiradev.zoo.entities.Habitat;

public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário

}
