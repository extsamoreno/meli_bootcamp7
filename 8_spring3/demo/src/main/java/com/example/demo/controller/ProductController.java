package com.example.demo.controller;

import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;
import com.example.demo.service.IIngredientesService;
import com.example.demo.service.dto.IngredienteDTO;
import com.example.demo.service.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class ProductController {

    @Autowired
    IIngredientesService iIngredientesService;


    @PostMapping("/calorias")
    public ResponseDTO getCalorias(@RequestBody Plato plato){
        ResponseDTO response = new ResponseDTO();
        response.setCalorias(iIngredientesService.getCalorias(plato));
        response.setIngredientes(iIngredientesService.getListCalorias(plato));
        response.setCaloriasMax(iIngredientesService.getMaxCalorias(plato));
        return response;
    }
}
