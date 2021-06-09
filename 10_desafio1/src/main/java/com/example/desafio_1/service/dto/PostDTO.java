package com.example.desafio_1.service.dto;

import com.example.desafio_1.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
    private int id_post;
    private int userId;
    private String date;
    private int category;
    private double price;
    private ProductDTO detail;
}
