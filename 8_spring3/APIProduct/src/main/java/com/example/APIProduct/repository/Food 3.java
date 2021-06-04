package com.example.APIProduct.repository;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private String name;
    private List<Ingredient> listIngredient;

}
