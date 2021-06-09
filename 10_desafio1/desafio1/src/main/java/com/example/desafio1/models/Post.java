package com.example.desafio1.models;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Post {
    private int idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

    public Post(int idPost, LocalDate date, Product detail, int category, double price) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.00;
    }

    public Post(PostDTO postDTO) {
        this.idPost = postDTO.getIdPost();
        this.date = postDTO.getDate();
        this.detail = postDTO.getDetail();
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
        this.hasPromo = false;
        this.discount = 0.00;
    }

    public Post(PostPromoDTO postPromoDTO) {
        this.idPost = postPromoDTO.getIdPost();
        this.date = postPromoDTO.getDate();
        this.detail = postPromoDTO.getDetail();
        this.category = postPromoDTO.getCategory();
        this.price = postPromoDTO.getPrice();
        this.hasPromo = postPromoDTO.isHasPromo();
        this.discount = postPromoDTO.getDiscount();
    }
}
