package com.example.springclase3.exercise1.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Plate {

    private String name;
    private ArrayList<Ingredient> ingredients;
    private Integer plateCalories;

}
