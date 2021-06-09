package com.socialmedia.socialmedia.services.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
