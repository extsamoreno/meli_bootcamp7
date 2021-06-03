package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class MealDTO {

    private String name;
    private List<IngredientReqDTO> ingredients;

}
