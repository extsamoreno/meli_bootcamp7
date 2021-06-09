package com.meli.desafio1.web.dto;

import com.meli.desafio1.web.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private int userId;
    private int id_post;
    private String date;
    private Producto detail;
    private String category;
    private float price;
}
