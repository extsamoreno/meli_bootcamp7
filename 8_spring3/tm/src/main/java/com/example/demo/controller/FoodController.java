package com.example.demo.controller;

import com.example.demo.dto.DishDTO;
import com.example.demo.dto.FoodResponseDTO;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/singleDish")
    public ResponseEntity<FoodResponseDTO> getDishCalories(@RequestBody DishDTO dishDTO) throws FileNotFoundException {

        return new ResponseEntity<>(foodService.getCalories(dishDTO), HttpStatus.OK);
    }

    @PostMapping("/multipleDishes")
    public ResponseEntity<List<FoodResponseDTO>> getMultipleDishesCalories(@RequestBody List<DishDTO> dishDTOList) throws FileNotFoundException {

        List<FoodResponseDTO> foodResponseDTOList = foodService.getMultipleDishesCalories(dishDTOList);
        return new ResponseEntity<>(foodResponseDTOList, HttpStatus.OK);
    }
}
