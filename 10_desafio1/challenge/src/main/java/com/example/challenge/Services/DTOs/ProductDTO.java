package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("productName")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
