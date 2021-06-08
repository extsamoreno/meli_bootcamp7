package com.meli.spring_challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String userID;
    private Product product;
    private int category;
    private double price;
}
