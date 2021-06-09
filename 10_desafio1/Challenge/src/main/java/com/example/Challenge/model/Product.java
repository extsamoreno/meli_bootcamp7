package com.example.Challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer userId;
    private Integer idPost;
    private String date;
    private ProductDetail detail;
    private Integer category;
    private Double price;

    public LocalDate getDateFromString(){
        LocalDate resultDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
        return resultDate;
    }



}
