package com.example.SocialMeli.Models;


import com.example.SocialMeli.Services.DTOs.ProductDTO;
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
    private Boolean hasPromo;
    private double discount;

    public Post(int id, int userId, String date, int productId, String category, double price, Boolean hasPromom, double discount) throws DateTimeParseException {

        this.id = id;
        this.userId = userId;
        this.date = LocalDate.parse(date).toString();
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromom;
        this.discount = discount;

    }


}
