package com.socialMeli.product.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int idPost;
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
