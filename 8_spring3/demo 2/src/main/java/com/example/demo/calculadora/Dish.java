package com.example.demo.calculadora;

import com.example.demo.calculadora.repository.Ingredients;
import com.example.demo.calculadora.repository.IngredientsRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private ArrayList<Ingredients> listIngredients;
}
