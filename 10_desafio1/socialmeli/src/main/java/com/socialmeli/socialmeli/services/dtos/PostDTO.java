package com.socialmeli.socialmeli.services.dtos;
import com.socialmeli.socialmeli.models.Product;
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
