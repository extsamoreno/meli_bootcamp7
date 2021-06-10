package com.example.demo.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int product_id;
    private String product_name, type, brand, color, notes;
}
