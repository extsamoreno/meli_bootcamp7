package com.example.APIProduct.repository;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int peso, calories;

    public Ingredient(String name, int peso) {
        this.name = name;
        this.peso = peso;
    }


}
