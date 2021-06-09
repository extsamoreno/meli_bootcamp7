package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
