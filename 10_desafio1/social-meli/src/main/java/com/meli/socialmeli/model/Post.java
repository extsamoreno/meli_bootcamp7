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
}
