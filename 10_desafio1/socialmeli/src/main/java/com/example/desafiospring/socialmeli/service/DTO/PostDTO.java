package com.example.desafiospring.socialmeli.service.DTO;

import com.example.desafiospring.socialmeli.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDTO {
    int userId;
    int id_post;
    String date;
    Product detail;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    int category;
    double price;
}
