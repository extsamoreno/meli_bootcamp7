package com.testingchallenge.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {
    private String name;
    private Double price;
}
