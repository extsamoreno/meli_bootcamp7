package com.meli.desafio.posts.models.dto;

import com.meli.desafio.posts.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostPromoDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;
}
