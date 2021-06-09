package com.desafiospring.socialMeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int userId;
    private int id_post;
    private Date date;
    private Product detail;
    private String category;
    private double price;

    public Post(int id_post, int userId) {
    }
}
