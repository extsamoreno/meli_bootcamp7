package com.spring3.calculadorapropia.service.dtos;

import java.util.ArrayList;

import com.spring3.calculadorapropia.service.dtos.IngredientRequestDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class FoodRequestDTO {
    private String name;
    private ArrayList<IngredientRequestDTO> ingredients;
}
