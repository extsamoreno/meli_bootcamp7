package com.example.desafio1.dtos;

import com.example.desafio1.models.Post;
import com.example.desafio1.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int userId;
    private int id_post;
    private LocalDateTime date;
    private Product detail;
    private int category;
    private double price;

    public PostDTO(Post post) {
        this.userId = 0;
        this.id_post = post.getId_post();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
