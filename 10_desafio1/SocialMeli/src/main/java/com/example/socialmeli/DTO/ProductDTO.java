package com.example.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
