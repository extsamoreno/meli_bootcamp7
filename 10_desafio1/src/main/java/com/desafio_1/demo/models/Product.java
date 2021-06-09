package com.desafio_1.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int userId;
    @JsonProperty("id_post")
    private int idPost;
    private Date date;
    private ProductDetail detail;
    private int category;
    private double price;
}
