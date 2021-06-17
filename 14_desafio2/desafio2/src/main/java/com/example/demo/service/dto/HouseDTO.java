package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {
    private String name;
    private double squareMeter;
    private double price;
    private String biggestEnvironment;
    private ArrayList<String> listEnvironment;
}
