package com.spring3.ejercicios.food.controller;

import com.spring3.ejercicios.food.service.FoodDTO;
import com.spring3.ejercicios.food.service.FoodResponseDTO;
import com.spring3.ejercicios.food.service.IFoodService;
import com.spring3.ejercicios.food.service.IMultipleFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @Autowired
    IMultipleFoodService iMultipleFoodService;

    @PostMapping("/food")
    public ResponseEntity<FoodResponseDTO> sendFood(@RequestBody FoodDTO foodDTO){
        return new ResponseEntity<>(iFoodService.responseFoodDTO(foodDTO), HttpStatus.OK );
    }

    @PostMapping("/multiplefood")
    public ResponseEntity<List<FoodResponseDTO>> multipleFood(@RequestBody ArrayList<FoodDTO> listFoodDTO){
        return new ResponseEntity<>(iMultipleFoodService.multipleResponseFoodDTO(listFoodDTO), HttpStatus.OK );
    }

}
