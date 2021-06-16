package com.bootcamp.desafio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    //private int prop_id;
    private String prop_name;
    private District district;
    private ArrayList<Environment> environments;

}
