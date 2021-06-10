package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int userId;
    private int id_post;
    private String date;
    private DetailDTO detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    public PostDTO(int userId, int id_post, String date, DetailDTO detail, Integer category, Double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}

