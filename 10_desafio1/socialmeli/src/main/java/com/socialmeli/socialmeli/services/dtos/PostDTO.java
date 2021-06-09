package com.socialmeli.socialmeli.services.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.socialmeli.models.Product;
import lombok.Data;
import java.util.Date;

@Data
public class PostDTO {
    int userId;
    int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    Date date;
    Product details;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    int category;
    double price;
}
