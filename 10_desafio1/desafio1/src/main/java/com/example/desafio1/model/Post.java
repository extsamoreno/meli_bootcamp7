package com.example.desafio1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    private Integer idPost;

    private @JsonFormat(pattern = "dd-mm-yyyy")
    Date date;

    private ProductDetail detail;
    private int category;
    private double price;
}
