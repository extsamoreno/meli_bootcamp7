package com.meli.calories.domain;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
