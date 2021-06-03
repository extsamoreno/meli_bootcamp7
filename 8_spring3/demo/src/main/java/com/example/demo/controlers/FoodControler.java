package com.example.demo.controlers;

import com.example.demo.service.DishService;
import com.example.demo.dto.DishDTO;
import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodControler {

    @GetMapping("/ping")
    public String status(){
        final String pong = "pong";
        return pong;
    }

    @Autowired
    private IDishService dishService;
//    private DishService dishService;

    @PostMapping("/calories")
    public ResponseEntity<FoodCaloriesDTO> getCalories(@RequestBody DishDTO dish){
        return  new ResponseEntity<>(dishService.getCalories(dish), HttpStatus.OK);
    }

}
