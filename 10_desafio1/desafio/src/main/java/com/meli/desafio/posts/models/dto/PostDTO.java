package com.meli.desafio.posts.models.dto;

import com.meli.desafio.posts.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Integer userId;
    private Integer postId;
    private String date;
    private Product detail;
    private Integer category;
    private double price;
}
