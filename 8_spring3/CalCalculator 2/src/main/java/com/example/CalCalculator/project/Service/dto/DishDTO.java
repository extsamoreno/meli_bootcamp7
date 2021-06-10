package com.example.CalCalculator.project.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class DishDTO {

    private String name;
    private List<FoodDTO> ingredients;
    private double calories;
    private FoodDTO mostCaloric;
}