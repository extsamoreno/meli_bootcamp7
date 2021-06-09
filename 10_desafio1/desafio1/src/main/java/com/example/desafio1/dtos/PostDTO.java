package com.example.desafio1.dtos;

import com.example.desafio1.models.Post;
import com.example.desafio1.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int userId;
    private int idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    public PostDTO(Post post) {
        this.userId = 0;
        this.idPost = post.getIdPost();
        this.date = post.getDate();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
