package com.example.socialmeli.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productname, type, brand, color, notes;
}
