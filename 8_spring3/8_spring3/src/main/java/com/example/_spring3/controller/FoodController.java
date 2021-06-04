package com.example._spring3.controller;

import com.example._spring3.dto.FoodDTO;
import com.example._spring3.dto.ResponseFoodDTO;
import com.example._spring3.service.IFoodService;
import com.example._spring3.service.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/calories")
    public ResponseEntity<ResponseFoodDTO> calculateCalories(@RequestBody FoodDTO food){
        return new ResponseEntity(processFood(food), HttpStatus.OK);
    }

    @PostMapping("/calories/list")
    public ResponseEntity<List<ResponseFoodDTO>> processFoodCalories(@RequestBody List<FoodDTO> foodArr){
        List<ResponseFoodDTO> respFood = new ArrayList<>();
        for (FoodDTO food : foodArr) {
            respFood.add(processFood(food));
        }
        return new ResponseEntity(respFood, HttpStatus.OK);
    }

    private ResponseFoodDTO processFood(FoodDTO food){
        ResponseFoodDTO responseDTO = new ResponseFoodDTO();

        responseDTO.setTotCalories(iFoodService.calculateTotalCalories(food));
        responseDTO.setCalIngredients(IngredientMapper.listToDTO(iFoodService.calculateCalIngredients(food)));
        responseDTO.setMostCalIngredient(IngredientMapper.toDTO(iFoodService.getMostCalIngredient(food)));

        return responseDTO;
    }

}
