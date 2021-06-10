package com.example.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer userId;
    private Integer idPost;
    private String date;
    private ProductDetail detail;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;

    //Constructor for Product without promo
    public Product(Integer userId, Integer idPost, String date, ProductDetail detail, Integer category, double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    //Convert String to LocalDate
    public LocalDate getDateFromString(){
        LocalDate resultDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        return resultDate;
    }



}
