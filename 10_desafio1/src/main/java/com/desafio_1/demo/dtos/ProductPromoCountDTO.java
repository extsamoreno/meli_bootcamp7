package com.desafio_1.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoCountDTO {
    private int userId;
    private String userName;
    @JsonProperty("promoproducts_count")
    private int promoProductsCount;
}
