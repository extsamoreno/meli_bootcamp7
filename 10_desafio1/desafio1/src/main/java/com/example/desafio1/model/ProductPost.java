package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPost {
    private int userId;
    private int id_post;
    private Date date;
    private Product detail;
    private int category;
    private double price;

}
