package com.example.springclase3.exercise1.controller;

import com.example.springclase3.exercise1.service.dto.InputPlate;
import com.example.springclase3.exercise1.repository.Plate;
import com.example.springclase3.exercise1.service.IPlateService;
import com.example.springclase3.exercise1.service.dto.PlateCalorieIngredientsDTO;
import com.example.springclase3.exercise1.service.dto.CaloriesPlateDTO;
import com.example.springclase3.exercise1.service.dto.IngredientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calories")
public class FoodController {

    @Autowired
    IPlateService iPlateService;

    @PostMapping("/savePlate")
    public ResponseEntity<String> savePlate(@RequestBody InputPlate inputPlate){
        return new ResponseEntity<>(iPlateService.savePlate(inputPlate), HttpStatus.CREATED);
    }

    @GetMapping("/plateCalories/{plateName}")
    public ResponseEntity<CaloriesPlateDTO> getPlateCalorieDTO(String plateName){
        return new ResponseEntity<>(iPlateService.getPlateCalorieDTO(plateName), HttpStatus.OK);
    }

    @GetMapping("/ingredientsCalories/{plateName}")
    public ResponseEntity<PlateCalorieIngredientsDTO> getPlateIngredientsCalorieDTO(String plateName){
        return new ResponseEntity<>(iPlateService.getPlateIngredientsCalorieDTO(plateName), HttpStatus.OK);
    }

    @GetMapping("/mostIngredientCalories/{plateName}")
    public ResponseEntity<IngredientDTO> getCaloriesIngredientDTO(String plateName){
        return new ResponseEntity<>(iPlateService.getMostCalorieIngredientDTO(plateName), HttpStatus.OK);
    }

}
