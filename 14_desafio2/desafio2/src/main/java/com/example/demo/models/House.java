package com.example.demo.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class House {
    private String prop_name;
    private District district;
    private ArrayList<Environment> environmentArrayList;
}

