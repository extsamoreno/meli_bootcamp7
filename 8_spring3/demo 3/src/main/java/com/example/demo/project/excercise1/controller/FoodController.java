package com.example.demo.project.excercise1.controller;

import com.example.demo.project.excercise1.repository.entities.Plato;
import com.example.demo.project.excercise1.repository.entities.Platos;
import com.example.demo.project.excercise1.service.*;
import com.example.demo.project.excercise1.service.dto.PlatoDTO;
import com.example.demo.project.excercise1.service.dto.PlatosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
public class FoodController {

    //Cuando spring hace la compilacion, busca la clase que implementa esa interfaz y le hace un new.
    @Autowired
    IFoodService iFoodService;


    @PostMapping("/calorias")
    public ResponseEntity<PlatoDTO> getCalorias(@RequestBody Plato plato){
        //iIngredienteService = new IngredienteService(); //Esto es lo mismo que hacer el autowired

        return new ResponseEntity<PlatoDTO>(iFoodService.getPlatoCalorias(plato), HttpStatus.OK);
    }

    @PostMapping("/calorias/platos")
    public ResponseEntity<PlatosDTO> getCaloriasPlatos(@RequestBody Platos platos){
        return new ResponseEntity<PlatosDTO>(iFoodService.getAllPlatosCalorias(platos), HttpStatus.OK);
    }
}


