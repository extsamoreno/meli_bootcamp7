package com.springChallenge.api.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int userId;
    private int idPost;
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
