package com.example.desafio1.dtos;

import com.example.desafio1.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingDTO {
    private int userId;
    private int idPost;
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
}
