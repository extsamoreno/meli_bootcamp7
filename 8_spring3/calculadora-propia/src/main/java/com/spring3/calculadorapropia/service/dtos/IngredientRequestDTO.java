package com.spring3.calculadorapropia.service.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class IngredientRequestDTO {
    private String name;
    private int weight;
}
