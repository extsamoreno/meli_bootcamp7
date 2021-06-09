package com.desafio.SocialMeli.DTO.Post;

import com.desafio.SocialMeli.DTO.Product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO{
    private boolean hasPromo;
    private double discount;

    public PromoPostDTO(int userId, int id_post, Date date, ProductDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(id_post, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
