package com.example.challenge.Models;

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
    private int id;
    private LocalDate date;
    private Product product;
    private int categoryId;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public Post(int userId, int id, LocalDate date, Product product, int categoryId, double price){
        this.userId = userId;
        this.id = id;
        this.date = date;
        this.product = product;
        this.categoryId = categoryId;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0;
    }

}
