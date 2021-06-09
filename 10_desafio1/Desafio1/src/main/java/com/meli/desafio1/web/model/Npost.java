package com.meli.desafio1.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Npost {
    private int userId;
    private int id_post;
    private String date;
    private Producto detail;
    private String category;
    private float price;
}
