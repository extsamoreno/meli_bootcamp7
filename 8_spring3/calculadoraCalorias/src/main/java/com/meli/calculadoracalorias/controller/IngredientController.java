package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.service.IIngredientService;
import com.meli.calculadoracalorias.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IIngredientService ingredientService;

    @GetMapping("")
    public ResponseEntity<List<IngredientDTO>> getAll() {
        return new ResponseEntity<List<IngredientDTO>>(ingredientService.getAllInDto(), HttpStatus.OK);
    }
}
