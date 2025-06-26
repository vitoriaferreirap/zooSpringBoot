package com.vitoriaferreiradev.zoo.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitoriaferreiradev.zoo.entities.enums.Presenca;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria; // ex: Leão, Tartaruga, Macaco, etc.
    private String dieta; // carnivora, herbívora, onívora

    private Integer presenca;

    @ManyToOne
    @JsonIgnore
    private Habitat habitat;

    public Animal() {

    }

    public Animal(Long id, String nome, String categoria, String dieta, Presenca presenca, Habitat habitat) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.dieta = dieta;
        setPresenca(presenca);
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Presenca getPresenca() {
        return Presenca.toEnum(this.presenca); // converte o código inteiro para o enum Presenca
    }

    public void setPresenca(Presenca presenca) {
        this.presenca = presenca.getCodigo(); // converte o enum Habitat para o código inteiro
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
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
