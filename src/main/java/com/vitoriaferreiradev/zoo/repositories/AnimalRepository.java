package com.vitoriaferreiradev.zoo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoriaferreiradev.zoo.entities.Animal;

//interface que estende JpaRepository = fornece métodos para acessar o banco de dados
// JpaRepository<Entidade, Tipo da chave primaria>
public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
