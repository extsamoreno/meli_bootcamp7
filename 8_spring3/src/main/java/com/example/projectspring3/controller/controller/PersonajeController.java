package com.example.projectspring3.controller.controller;

import com.example.projectspring3.controller.repository.IPersonajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personajes")

public class PersonajeController {
    @Autowired
    IPersonajesRepository iPersonajesRepository;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<String>> getNombrePersonaje(@PathVariable("nombre") String nombre){
        return new ResponseEntity<>(iPersonajesRepository.getPersonajeByName(nombre), HttpStatus.OK);
    }
}
