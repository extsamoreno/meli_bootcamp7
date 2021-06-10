package com.example.challenge.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int categoryId;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public Post(int userId, int id, LocalDate date, Product product, int categoryId, double price) {
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
