package com.spring3.demo.Objects;

import com.spring3.demo.Objects.DTO.IngredientInput;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private ArrayList<IngredientInput> ingredientInputs;
}
