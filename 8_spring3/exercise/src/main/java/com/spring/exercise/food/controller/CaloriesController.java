package com.spring.exercise.food.controller;

import com.spring.exercise.food.service.ICaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caculate-calories")
public class CaloriesController {

    @Autowired
    ICaloriesService caloriesService;


}
