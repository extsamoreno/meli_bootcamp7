package com.example.desafio1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}