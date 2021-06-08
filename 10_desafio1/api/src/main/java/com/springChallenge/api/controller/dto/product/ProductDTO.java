package com.springChallenge.api.controller.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
