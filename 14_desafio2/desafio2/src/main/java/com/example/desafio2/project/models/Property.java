package com.example.desafio2.project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private String prop_name;
    private String prop_district_name;
    private ArrayList<Environment> prop_environment;
}
