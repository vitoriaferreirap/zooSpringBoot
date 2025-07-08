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

    public Habitat inserir(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public Habitat update(Long id, Habitat habitat) {
        Habitat entity = habitatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitat não encontrado!"));
        updateData(entity, habitat);
        return habitatRepository.save(entity);
    }

    private void updateData(Habitat entity, Habitat habitat) {
        entity.setNome(habitat.getNome());
    }

    public void deletar(Long id) {
        Habitat habitat = habitatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitat não encontrado!"));

        if (!habitat.getAnimaisHabitats().isEmpty()) {
            throw new RuntimeException("Não é possível excluir um habitat que possui animais");
        }
        habitatRepository.delete(habitat);
    }
}
