package com.meli.socialmeli.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
