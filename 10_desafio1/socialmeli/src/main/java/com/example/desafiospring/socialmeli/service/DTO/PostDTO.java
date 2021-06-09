package com.example.desafiospring.socialmeli.service.DTO;

import com.example.desafiospring.socialmeli.model.Product;
import lombok.Data;

@Data
public class PostDTO {
    int userId;
    int id_post;
    String date;
    Product details;
    String category;
    double price;
}
