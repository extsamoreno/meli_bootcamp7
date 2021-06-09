package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    int product_id;         //: 1,
    String productName;     // : "Silla Gamer",
    String type;            // : "Gamer",,
    String brand;           //: "Racer"
    String color;           //" : "Red & Black",
    String notes;           // : "Special Edition"

}
