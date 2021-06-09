package com.socialmeli.socialmeli.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Post {
    int userId;
    int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    Date date;
    Product details;
    int category;
    double price;
}
