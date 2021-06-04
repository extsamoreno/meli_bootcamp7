package com.spring3.spring3.PracticoMañana.DTO;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodDTO {
    private String name;
    private List<IngredientDTO> ingredients;
}
