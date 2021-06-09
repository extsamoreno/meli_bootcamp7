package com.socialmeli.socialmeli.services.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.socialmeli.models.Product;
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
