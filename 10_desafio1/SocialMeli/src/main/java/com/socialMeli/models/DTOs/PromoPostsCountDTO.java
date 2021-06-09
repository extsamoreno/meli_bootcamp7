package com.socialMeli.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostsCountDTO {

    private Integer userId;
    private String username;
    private Integer promoProductsCount;
}
