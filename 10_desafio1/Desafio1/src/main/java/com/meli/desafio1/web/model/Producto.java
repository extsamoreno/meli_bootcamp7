package com.meli.desafio1.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
