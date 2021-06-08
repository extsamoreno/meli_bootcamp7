package com.meli.desafio.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    Integer productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
}
