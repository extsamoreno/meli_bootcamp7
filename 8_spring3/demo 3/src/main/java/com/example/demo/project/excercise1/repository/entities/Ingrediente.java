package com.example.demo.project.excercise1.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {

    private int id;
    private String name;
    private Integer weight;
    private Integer calories;


    public Ingrediente(String name, Integer weight, Integer calories){
        this.name = name;
        this.weight = weight;
        this.calories = calories;
    }
}
