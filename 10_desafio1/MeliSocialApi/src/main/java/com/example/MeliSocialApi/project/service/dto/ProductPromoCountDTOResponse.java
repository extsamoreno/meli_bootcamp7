package com.example.MeliSocialApi.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoCountDTOResponse {
    private Integer userId;
    private String userName;
    private Integer promoProductCount;
}
