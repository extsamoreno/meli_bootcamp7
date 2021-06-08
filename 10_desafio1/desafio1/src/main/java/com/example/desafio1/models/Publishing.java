package com.example.desafio1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publishing {
    private int userId;
    private int idPost;
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
