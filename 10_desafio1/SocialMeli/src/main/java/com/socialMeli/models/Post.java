package com.socialMeli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int idPost;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    public Product getDetail(){ return null;}
}
