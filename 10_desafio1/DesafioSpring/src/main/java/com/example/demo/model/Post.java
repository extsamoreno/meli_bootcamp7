package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int id_post;
    private Date date;
    private Product product;
    private Category category;
    private double price;

}
