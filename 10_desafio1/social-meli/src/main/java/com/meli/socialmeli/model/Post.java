package com.meli.socialmeli.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    public Integer userId;
    public Integer id_post;
    public String date;
    public Integer product_id;
    public Integer category;
    public double price;
    public boolean hasPromo;
    public double discount;
}
