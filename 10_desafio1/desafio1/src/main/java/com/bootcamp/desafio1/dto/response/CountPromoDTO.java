package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountPromoDTO extends UserDTO {

    private int promoProductsCount;

    public CountPromoDTO(int userId, String userName, int promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
