package com.example.demo.controller;

import com.example.demo.entity.Plato;
import com.example.demo.service.IIngredientesService;
import com.example.demo.service.dto.IngredienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plato")
public class ProductController {

    @Autowired
    IIngredientesService iIngredientesService;


    @PostMapping("/calorias")
    public double getCalorias(@RequestBody Plato plato){
        return iIngredientesService.getCalorias(plato);
    }
}
