package com.example.projectspring3.controller.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredients> listaIngredientes = new ArrayList<>();
}
