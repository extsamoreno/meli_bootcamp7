package com.desafio.socialMeli.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {
    private Integer userId;
    private Integer id_post;
    private String date;
    private Product detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private float discount;

    public boolean gethasPromo() {
        return this.hasPromo;
    }

    public void setDetail(Product detail) {
        this.detail = new Product(detail.getProduct_id(),
                detail.getProductName(),
                detail.getType(),
                detail.getBrand(),
                detail.getColor(),
                detail.getNotes());
    }

    public Product getDetail() {
        return this.detail;
    }

}
