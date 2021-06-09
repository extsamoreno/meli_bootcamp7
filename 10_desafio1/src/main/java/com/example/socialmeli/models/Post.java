package com.example.socialmeli.models;

import com.example.socialmeli.models.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Post {
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    public Post (PostDTO postDTO){
        this.postId = postDTO.getPostId();
        this.date = postDTO.getDate();
        this.detail = postDTO.getDetail();
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
    }
}
