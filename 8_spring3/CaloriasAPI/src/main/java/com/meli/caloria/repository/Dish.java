package com.meli.caloria.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meli.caloria.service.dto.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String nombre;
    private List<IngredientDTO> ingredientes= new ArrayList<>();
    @JsonIgnore
    private double totalCalories;
}
