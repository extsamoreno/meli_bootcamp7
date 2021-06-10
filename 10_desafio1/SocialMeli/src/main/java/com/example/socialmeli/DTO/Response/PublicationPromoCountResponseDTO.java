package com.example.socialmeli.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationPromoCountResponseDTO {
    private int userId;
    private String userName;
    private int promoProductsCount;
}
