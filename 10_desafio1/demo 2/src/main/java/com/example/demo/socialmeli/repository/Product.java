package com.example.demo.socialmeli.repository;

import lombok.Data;

@Data
public class Product {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
