package com.meli.testingchallenge.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {

    private String environment_name;
    private double environment_width;
    private double environment_length;

    public double calculateSurface() {
        return environment_length * environment_width;
    }
}
