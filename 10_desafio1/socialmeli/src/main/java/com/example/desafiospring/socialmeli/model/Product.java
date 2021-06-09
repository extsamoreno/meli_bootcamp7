package com.example.desafiospring.socialmeli.model;

import lombok.Data;

@Data
public class Product {  //el producto que devolveria
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
