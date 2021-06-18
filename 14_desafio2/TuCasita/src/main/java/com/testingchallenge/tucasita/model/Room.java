package com.testingchallenge.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name; // "cocina", "comedor"...
    private Double length;
    private Double width;
}
