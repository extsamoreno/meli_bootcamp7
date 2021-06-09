package com.example.SocialMeli.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


@Getter @Setter  @NoArgsConstructor
public class Post{

    private int id;
    private int userId;
    private String date;
    private int productId;
    private String category;
    private double price;

    public Post(int id, int userId, String date, int productId, String category, double price) throws DateTimeParseException {

        this.id = id;
        this.userId = userId;
        this.date = LocalDate.parse(date).toString();
        this.productId = productId;
        this.category = category;
        this.price = price;

    }


}
