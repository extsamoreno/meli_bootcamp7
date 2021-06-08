package com.meli.socialmeli.dto;

import lombok.Data;

@Data
public class ProductDetailDTO {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
