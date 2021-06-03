package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MealsDTO {
    private String menu;
    private List<MealDTO> meals;
}
