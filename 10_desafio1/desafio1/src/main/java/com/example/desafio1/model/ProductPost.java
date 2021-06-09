package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPost implements Precedeable<ProductPost>{
    private int userId;
    private int id_post;
    private String date;
    private Product detail;
    private int category;
    private double price;

    @Override
    public int precedeA(ProductPost productPost) {
        return this.getDate().compareTo(productPost.getDate());
    }
}
