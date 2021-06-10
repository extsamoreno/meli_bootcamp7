package com.desafio_1.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int userId;
    @JsonProperty("id_post")
    private int idPost;
    private LocalDate date;
    private ProductDetail detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
