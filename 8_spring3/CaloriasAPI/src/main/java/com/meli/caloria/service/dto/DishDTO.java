package com.meli.caloria.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishDTO {
    private String nombre;
    private double totalCalories;
}
