package com.example.desafio1.dtos;

import com.example.desafio1.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingDTORequest {
    private int userId;
    private int idPost;
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
}
