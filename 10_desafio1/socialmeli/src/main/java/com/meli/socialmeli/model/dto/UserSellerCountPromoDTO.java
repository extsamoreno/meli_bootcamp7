package com.meli.socialmeli.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellerCountPromoDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;
}
