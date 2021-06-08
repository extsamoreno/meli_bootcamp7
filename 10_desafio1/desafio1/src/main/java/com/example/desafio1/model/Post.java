package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    private int idPost;
    private Date date;
    ArrayList<ProductDetail> detail = new ArrayList<>();
    private String category;
    private double price;
}
