package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
