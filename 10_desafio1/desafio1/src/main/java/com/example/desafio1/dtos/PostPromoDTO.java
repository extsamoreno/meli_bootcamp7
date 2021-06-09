package com.example.desafio1.dtos;

import com.example.desafio1.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO extends PostDTO {
    private boolean hasPromo;
    private double discount;

    public PostPromoDTO(Post post) {
        super(post);
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
    }
}
