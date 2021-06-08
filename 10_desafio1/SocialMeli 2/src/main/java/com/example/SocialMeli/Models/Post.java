package com.example.SocialMeli.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Getter @Setter  @NoArgsConstructor
public class Post {

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
