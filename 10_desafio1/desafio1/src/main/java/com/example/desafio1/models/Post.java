package com.example.desafio1.models;

import com.example.desafio1.dtos.PostDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Post {
    private int id_post;
    private LocalDateTime date;
    private Product detail;
    private int category;
    private double price;

    public Post(int id_post, LocalDateTime date, Product detail, int category, double price) {
        this.id_post = id_post;
        /*
        String[] st = date.split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(st[2] + "/");
        sb.append(st[1] + "/");
        sb.append(st[0]);
        this.date = ....
         */
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post(PostDTO postDTO) {
        this.id_post = postDTO.getId_post();
        /*
        String[] st = postDTO.getDate().split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(st[2] + "/");
        sb.append(st[1] + "/");
        sb.append(st[0]);
        this.date = new Date(sb.toString());
         */
        this.date = postDTO.getDate();
        this.detail = postDTO.getDetail();
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
    }
}
