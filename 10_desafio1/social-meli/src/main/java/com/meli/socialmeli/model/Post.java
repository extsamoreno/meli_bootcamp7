package com.meli.socialmeli.model;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private Integer userId;
    private Integer postId;
    private Date date;
    private Product detail;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(Integer userId, Integer postId, Date date, Product detail, Integer category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
