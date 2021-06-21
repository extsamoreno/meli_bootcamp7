package com.example.demo.model.DTO;

import com.example.demo.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PostDTO {

    private int userId;
    private int postId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    Date date;
    private Product detail = new Product();
    private int category;
    private double price;


}
