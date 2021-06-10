package com.example.desafio_1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private int userId;
    private Date createdDate;
    private int categoryId;
    private double price;
    private Product detail;
    private boolean hasPromo;
    private double discount;
}
