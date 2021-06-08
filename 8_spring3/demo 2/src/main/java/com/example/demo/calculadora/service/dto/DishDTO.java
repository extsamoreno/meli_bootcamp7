package com.example.demo.calculadora.service.dto;

import com.example.demo.calculadora.repository.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String name;
    private int calories;
    private ArrayList<Ingredients> arrayList;
}
