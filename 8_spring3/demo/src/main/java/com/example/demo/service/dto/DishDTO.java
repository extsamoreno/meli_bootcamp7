package com.example.demo.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class DishDTO {

    private String name;
    private List<IngredientReqDTO> ingridients;

}
