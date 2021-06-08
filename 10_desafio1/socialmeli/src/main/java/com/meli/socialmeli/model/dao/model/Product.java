package com.meli.socialmeli.model.dao.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String producName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
