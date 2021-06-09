package com.meli.desafio.posts.models.dto;

import com.meli.desafio.posts.models.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PostDTO {
    Integer userId;
    Integer postId;
    String date;
    Product detail;
    Integer category;
    double price;
}
