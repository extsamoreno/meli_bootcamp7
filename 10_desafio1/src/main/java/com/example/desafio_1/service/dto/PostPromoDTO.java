package com.example.desafio_1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPromoDTO extends PostDTO{

    private boolean hasPromo;
    private double discount;

    public PostPromoDTO(int id_post, int userId, String date, int category, double price, ProductDTO detail, boolean hasPromo, double discount) {
        super(id_post, userId, date, category, price, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
