package com.meli.desafio.posts.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromoCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoCount;
}
