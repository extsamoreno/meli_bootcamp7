package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    private Date date;
    private ProductDetail detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
