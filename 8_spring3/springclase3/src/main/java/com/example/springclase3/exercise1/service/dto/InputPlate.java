package com.example.springclase3.exercise1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class InputPlate {

    private String name;
    private ArrayList<InputIngredient> plateIngredients;

}
