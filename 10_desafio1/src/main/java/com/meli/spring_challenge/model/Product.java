package com.meli.spring_challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productID;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private boolean hasPromo;
    private double discount;
}
