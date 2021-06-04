package com.example._spring3.dto;

import com.example._spring3.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String name;
    private List<IngredientDTO> ingredients;
}
