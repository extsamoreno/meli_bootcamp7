package com.example.desafiospring.socialmeli.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTO {

    private Integer userId;
    private String username;
    private Integer promoProductsCount;
}
