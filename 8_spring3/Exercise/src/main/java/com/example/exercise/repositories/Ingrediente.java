package com.example.exercise.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
    private String name;
    private int calories;
    private int peso;
}
