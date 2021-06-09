package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private int userId;
    private int postId;
    private String date;
    private ProductDTO detail;
    private String category;
    private double price;



    public PostDTO(int userId, int postId, String date, ProductDTO detail, String category, double price) throws DateTimeParseException {

        this.userId = userId;
        this.postId = postId;
        this.date = LocalDate.parse(date).toString();
        this.detail = detail;
        this.category = category;
        this.price = price;

    }
}
