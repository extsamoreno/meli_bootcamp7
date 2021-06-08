package com.example.desafio1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
