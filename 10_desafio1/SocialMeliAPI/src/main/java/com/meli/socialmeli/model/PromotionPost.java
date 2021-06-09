package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionPost extends Post{
    private boolean hasPromo;
    private double discount;

    public PromotionPost(PromotionPost post) {
        super();
        this.hasPromo = post.hasPromo;
        this.discount = post.getDiscount();
    }

}
