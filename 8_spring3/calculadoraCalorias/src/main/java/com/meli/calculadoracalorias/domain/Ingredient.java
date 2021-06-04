package com.meli.calculadoracalorias.domain;

import com.fasterxml.jackson.annotation.JsonKey;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private double weight;
}
