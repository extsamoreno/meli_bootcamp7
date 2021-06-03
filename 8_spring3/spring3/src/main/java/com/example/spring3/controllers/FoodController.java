package com.example.spring3.controllers;

import com.example.spring3.dtos.FoodDTO;
import com.example.spring3.dtos.ResponseFoodDTO;
import com.example.spring3.services.interfaces.IFoodService;
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
    IFoodService iFoodService;

    @PostMapping("/totalCalories")
    public ResponseEntity<ResponseFoodDTO> getCalories(@RequestBody FoodDTO foodDTO) {
        return new ResponseEntity(iFoodService.getCalories(foodDTO), HttpStatus.OK);
    }

    @PostMapping("/foods/totalCalories")
    public ResponseEntity<List<ResponseFoodDTO>> getPlatesCalories(@RequestBody FoodDTO[] foodDTO) {
        return new ResponseEntity(iFoodService.getPlatesCalories(foodDTO), HttpStatus.OK);
    }
}
