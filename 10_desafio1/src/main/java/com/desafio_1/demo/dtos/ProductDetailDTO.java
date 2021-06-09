package com.desafio_1.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    @JsonProperty("product_id")
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
