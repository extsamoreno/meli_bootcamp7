package com.meli.socialmeli.model.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int idPost;
    private Date date;
    private ArrayList<Product> detail = new ArrayList<>();
    private int category;
    private double price;
}
