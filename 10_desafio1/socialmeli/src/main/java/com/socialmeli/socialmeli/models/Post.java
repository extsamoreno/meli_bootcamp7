package com.socialmeli.socialmeli.models;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Post {
    int userId;
    int id_post;
    String date;
    Product detail;
    int category;
    double price;
}
