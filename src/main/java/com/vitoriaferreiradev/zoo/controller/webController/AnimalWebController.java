package com.vitoriaferreiradev.zoo.controller.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vitoriaferreiradev.zoo.entities.Animal;
import com.vitoriaferreiradev.zoo.services.AnimalServices;

/*
 * Thymeleaf precisa de templates HTML
 * (Server-Side)
 * 
 * FLUXO:
 *  1. Usuário acessa: /web/animais
    2. AnimalWebController chama: animalServices.linstarAnimais()
    3. AnimalServices usa: animalRepository.findAll()
    4. Dados vêm do banco: [{"nome":"Simba", "categoria":"Mamífero"}]
    5. Controller passa para template: model.addAttribute("animais", lista)
    6. Thymeleaf gera HTML com dados reais
 */
@Controller // retorna HTML
public class AnimalWebController {

    @Autowired
    private AnimalServices animalServices;// usa mesmo serviço da API

    @GetMapping
    public String listarAnimais(Model model) {
        List<Animal> animais = animalServices.linstarAnimais(); // mesma logica da API
        model.addAttribute("animais", animais);
        return "animais/index"; // retorna o template HTML
    }

}