package com.example.desafiospring.socialmeli.model;

import lombok.Data;

@Data

/**
 * the product that returns with its type, brand, color and notes
 */
public class Product {  //el producto que devolveria
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;

    public boolean getHasPromo(){
        return false;
    }
}
