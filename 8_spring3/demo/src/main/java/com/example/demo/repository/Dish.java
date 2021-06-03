package com.example.demo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private ArrayList<Ingredients> ingredients = new ArrayList<>();
}
