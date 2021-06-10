package com.bootcamp.socialmeli.DTO.request;

import com.bootcamp.socialmeli.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostPromoDTOreq extends PostDTOreq{
    private boolean hasPromo;
    private double discount;

    public PostPromoDTOreq(int userId, int postId, LocalDate date, ProductDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
