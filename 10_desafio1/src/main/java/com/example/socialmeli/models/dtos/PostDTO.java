package com.example.socialmeli.models.dtos;

import com.example.socialmeli.models.Post;
import com.example.socialmeli.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PostDTO {
    private int userId;
    private int postId;
    private Date date;
    private Product detail;
    private int category;
    private double price;

    public PostDTO(Post post) {
        this.postId = post.getPostId();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
