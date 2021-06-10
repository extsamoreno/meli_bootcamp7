package com.example.desafio1.service.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePromoPostCountDTO {

    private int userId;
    private String userName;
    private int promoProductsCount;
}
