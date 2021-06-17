package com.meli.testingchallenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estate {

    private String prop_name;
    private String district_name;
    private double district_price;
    private List<Environment> environments;

    public double calculateSurface() {

        return environments.stream()
                .mapToDouble(e -> e.calculateSurface())
                .sum();
    }

    public double calculatePrice(){
        return calculateSurface() * district_price;
    }



}
