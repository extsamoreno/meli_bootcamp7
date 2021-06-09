package com.meli.socialmeli.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostCount {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
