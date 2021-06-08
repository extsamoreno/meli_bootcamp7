package com.example.demo.controller;

import com.example.demo.dto.Personaje;
import com.example.demo.dto.PersonajeDTO;
import com.example.demo.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("/cargar")
    public String cargarBD(){

        return  personajeService.cargarBD();

    }
    @GetMapping("/personaje/{palabra}")
    public List<Personaje> buscarPersonajes(@PathVariable String palabra){

        return personajeService.retornarPersonaje(palabra);

    }

    @GetMapping("/nombre/{palabra}")
    public List<PersonajeDTO> buscarNombres(@PathVariable String palabra){

        return personajeService.retornarNombres(palabra);

    }

}
