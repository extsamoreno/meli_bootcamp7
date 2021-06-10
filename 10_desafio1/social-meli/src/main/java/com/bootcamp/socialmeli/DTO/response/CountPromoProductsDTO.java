package com.bootcamp.socialmeli.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountPromoProductsDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
