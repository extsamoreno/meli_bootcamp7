package com.desafiospring.socialMeli.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int id_post;
    private Date date;
    private Product detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
