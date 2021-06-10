package com.meli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    int id;
    int userId;
    int id_post;
    Date date;
    int productId;
    int category;
    double price;
    boolean hasPromo;
    double discount;

    public Post(int id, int userId, int id_post, Date date, int productId, int category, double price) {
        this.id = id;
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.productId = productId;
        this.category = category;
        this.price = price;
        hasPromo=false;
        discount = 0;
    }
}
