package com.meli.SocialMeli.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostPromResDto extends PostResDto{
    private boolean hasPromo;
    private double discount;

    public PostPromResDto(int id_post, String date, ProductDto detail, int category, double price, boolean hasPromo, double discount) {
        super(id_post,date,detail,category,price);
        this.hasPromo=hasPromo;
        this.discount=discount;
    }
}
