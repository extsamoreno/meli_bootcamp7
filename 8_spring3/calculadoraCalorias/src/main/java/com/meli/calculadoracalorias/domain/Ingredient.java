package com.meli.calculadoracalorias.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private double weight;
    private double calories;
}
