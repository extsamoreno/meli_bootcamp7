package com.example.demo.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;
    private String name;
    private String barcode;
    private Integer stock;
    


    public Product(String name, Integer stock){
        this.name = name;
        this.stock = stock;
    }
}
