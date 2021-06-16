package com.example.demo.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountPromoDTO {

    private int userId;
    private String username;
    private int promoProductsCount;
}
