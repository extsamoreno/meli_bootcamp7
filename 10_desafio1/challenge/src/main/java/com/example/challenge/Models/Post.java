package com.example.challenge.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int id;
    private LocalDate date;
    private Product product;
    private int categoryId;
    private double price;


}
