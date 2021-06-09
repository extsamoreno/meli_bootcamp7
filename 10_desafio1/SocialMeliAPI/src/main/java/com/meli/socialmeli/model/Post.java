package com.meli.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int userId;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;

    public Post(Post post){
        this.userId=post.getUserId();
        this.id_post=post.getId_post();
        this.date=post.getDate();
        this.detail=post.getDetail();
        this.category=post.getCategory();
        this.price=getPrice();
    }
}
