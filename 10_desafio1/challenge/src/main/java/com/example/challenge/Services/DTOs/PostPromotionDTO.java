package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromotionDTO {

    private int userId;
    @JsonProperty("id_post")
    private int id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("detail")
    private ProductDTO product;
    @JsonProperty("category")
    private int categoryId;
    private double price;
    private Boolean hasPromo;
    private double discount;

    public PostPromotionDTO(int userId, int id, LocalDate date, ProductDTO product, int categoryId, double price){
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


