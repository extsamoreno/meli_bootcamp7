package com.meli.desafio.posts.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PromoCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoCount;
}
