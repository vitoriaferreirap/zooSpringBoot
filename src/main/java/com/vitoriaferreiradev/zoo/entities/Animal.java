package com.vitoriaferreiradev.zoo.entities;

import java.io.Serializable;

import com.vitoriaferreiradev.zoo.entities.enums.Habitat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especie;
    private String dieta; // carnivora, herbívora, onívora

    private Integer habitat;

    public Animal() {

    }

    public Animal(Long id, String nome, String especie, String dieta, Habitat habitat) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.dieta = dieta;
        setHabitat(habitat);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Habitat getHabitat() {
        return Habitat.toEnum(this.habitat); // converte o código inteiro para o enum Habitat
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat.getCodigo(); // converte o enum Habitat para o código inteiro
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
