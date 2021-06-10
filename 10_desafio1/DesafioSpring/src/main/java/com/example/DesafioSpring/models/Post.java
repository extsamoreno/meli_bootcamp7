package com.example.DesafioSpring.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private LocalDate date;
    private int productId;
    private String category;
    private double price;
    private Boolean hasPromo;
    private double discount;




}
