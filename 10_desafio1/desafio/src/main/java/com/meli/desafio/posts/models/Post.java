package com.meli.desafio.posts.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Post{
    Integer userId;
    Integer postId;
    Date date;
    Product detail;
    Integer category;
    double price;

}
