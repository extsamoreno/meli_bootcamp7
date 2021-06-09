package com.reto1.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    int userId;
    int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date date;
    Product detail;
    int category;
    double price;
}
