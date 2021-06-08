package com.spring.desafioSpring.Models;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
