package com.example.desafiospring.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * the promo post, discount
 */
public class PromoPost extends Post {

    private boolean hasPromo = true;
    private double discount;

    @Override
    public boolean hasPromo() {
        return this.hasPromo;
    }
}