package com.meli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    int id;
    int product_id;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
