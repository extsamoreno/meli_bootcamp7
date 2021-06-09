package com.example.desafiospring.socialmeli.model;

import lombok.Data;

@Data
public class Product {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
