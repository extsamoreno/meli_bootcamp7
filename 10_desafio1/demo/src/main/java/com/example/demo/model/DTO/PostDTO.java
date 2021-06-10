package com.example.demo.model.DTO;

import com.example.demo.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {

    private int userId;
    private int postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    Date date;
    private Product detail = new Product();
    private int category;
    private double price;
}
