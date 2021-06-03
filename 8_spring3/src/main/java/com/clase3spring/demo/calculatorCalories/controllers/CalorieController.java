package com.clase3spring.demo.calculatorCalories.controllers;

import com.clase3spring.demo.calculatorCalories.models.CalorieDTO;
import com.clase3spring.demo.calculatorCalories.models.Food;
import com.clase3spring.demo.calculatorCalories.services.ICalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calories")
public class CalorieController {

    @Autowired
    private ICalorieService calorieService;

    /*
    @PostMapping
    public ResponseEntity<CalorieDTO> getCaloriesFood(@RequestBody Food food){
        return new ResponseEntity<CalorieDTO>(, HttpStatus.OK);
    }
*/
}
