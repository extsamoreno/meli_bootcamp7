package com.meli.caloria.controller;

import com.meli.caloria.repository.Dish;
import com.meli.caloria.repository.Ingredient;
import com.meli.caloria.service.IDishService;
import com.meli.caloria.service.dto.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    public IDishService iDishService;

    @PostMapping("/total_calories")
    public ResponseEntity<DishDTO> getResults(@RequestBody Dish dish){
        return new ResponseEntity<>(iDishService.calcularCaloriasTotales(dish), HttpStatus.OK);
    }

    @PostMapping("/calories_per_ingredient")
    public ResponseEntity<List<Ingredient>> getCaloriesPerProduct(@RequestBody Dish dish){
        return new ResponseEntity<>(iDishService.imprimirCaloriasPorIngrediente(dish),HttpStatus.OK);
    }

    @PostMapping("/most_caloric_ingredient")
    public ResponseEntity<Ingredient> getMostCaloricIngredient(@RequestBody Dish dish){
        return new ResponseEntity<>(iDishService.calcularIngredienteMasCalorico(dish),HttpStatus.OK);
    }

}
