package com.meli.desafio.posts.models.dto;

import com.meli.desafio.posts.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;

    @Builder(builderMethodName = "promoBuilder")
    public PostPromoDTO(Integer userId, Integer postId, String date, Product detail, Integer category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
