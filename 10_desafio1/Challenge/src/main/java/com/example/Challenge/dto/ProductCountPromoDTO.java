package com.example.Challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCountPromoDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;

}
