package com.example.CalCalculator.project.Controllers;

import com.example.CalCalculator.project.Entities.Dish;
import com.example.CalCalculator.project.Service.IFoodService;
import com.example.CalCalculator.project.Service.dto.DishDTO;
import com.example.CalCalculator.project.Service.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class FoodController {

    @Autowired
    IFoodService iFoodService;

    @PostMapping("/test")
    public ResponseEntity<DishDTO> getCalories(@RequestBody Dish dish){

        return new ResponseEntity<>(iFoodService.getDishData(dish), HttpStatus.OK);
    }
}
