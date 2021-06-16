package com.tucasitatasaciones.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {

    private int id;
    private String name;
    private double price;
}
