package com.bootcamp.desafio1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private int userId;
    private int postId;
    private Date date;
    private int productId;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
