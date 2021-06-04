package com.meli.API_calorie_calculator.service.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeveralFoodsDTO {
    private ArrayList<FoodDTO> severalFoods;
}
