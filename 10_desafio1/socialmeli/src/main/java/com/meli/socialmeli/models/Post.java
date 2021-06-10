package com.meli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    int userId;         //: 1235,
    int id_post;        // : 18,
    String date;        // : "29-04-2021",
    Product detail;
    int category;       // :100,
    double price;       // :1500.50,




}
