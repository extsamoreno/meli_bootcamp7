package com.example.springclase3.exercise1.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Ingredient { //Ingredient in a plate

    private String name;
    private Integer weight;
    //calories per gram
    private Integer calories;

}
