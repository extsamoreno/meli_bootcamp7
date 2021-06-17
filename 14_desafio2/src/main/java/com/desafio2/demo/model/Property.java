package com.desafio2.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
    private int id;
    private String name;
    private String address;
    private String neighborhood;
    private List<Environment> environments;
}
