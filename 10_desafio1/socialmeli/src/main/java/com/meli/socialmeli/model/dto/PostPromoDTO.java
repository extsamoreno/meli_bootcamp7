package com.meli.socialmeli.model.dto;

import com.meli.socialmeli.model.dao.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostPromoDTO {
    private int idPost;
    private String date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
