package com.bootcamp.desafio2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private String prop_name;
    private District district;
    private ArrayList<Environment> environments;

}
