package com.example.desafio_1.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PromoListDTO extends UserDataBase{
    private List<PostPromoDTO> promos;

    public PromoListDTO(int userId, String userName, List<PostPromoDTO> promos) {
        super(userId, userName);
        this.promos = promos;
    }
}
