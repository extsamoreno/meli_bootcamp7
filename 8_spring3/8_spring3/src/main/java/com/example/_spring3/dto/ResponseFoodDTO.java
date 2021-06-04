package com.example._spring3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFoodDTO {
    private int totCalories;
    private List<ResponseIngredientDTO> calIngredients;
    private ResponseIngredientDTO mostCalIngredient;
}
