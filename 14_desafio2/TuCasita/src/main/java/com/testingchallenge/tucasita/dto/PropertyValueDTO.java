package com.testingchallenge.tucasita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// US002 - get the full value of a property

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyValueDTO {
    private String name;
    private Double price;
}
