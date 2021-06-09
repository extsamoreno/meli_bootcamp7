package com.example.challenge.Services.DTOs;

import com.example.challenge.Models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class PostDTO {
    private int userId;
    private int id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int categoryId;
    private double price;
}
