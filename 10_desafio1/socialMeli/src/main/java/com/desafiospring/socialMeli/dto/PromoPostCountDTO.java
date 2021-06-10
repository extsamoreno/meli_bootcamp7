package com.desafiospring.socialMeli.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
public class PromoProductsCountDTO extends UserDTO {

    private int promoproducts_count;

    public PromoProductsCountDTO(int userId, String userName, int count) {
    }
}
