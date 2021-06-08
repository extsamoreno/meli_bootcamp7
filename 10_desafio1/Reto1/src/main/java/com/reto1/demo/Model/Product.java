package com.reto1.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    int product_id;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
