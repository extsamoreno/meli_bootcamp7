package com.springChallenge.api.controller.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springChallenge.api.controller.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CountPromoDTO extends UserDTO {
    @JsonProperty("promoproducts_count")
    private int promoProductsCount;

    public CountPromoDTO(int userId, String userName, int promoProductsCount){
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
