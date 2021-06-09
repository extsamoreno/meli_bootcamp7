package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PostPromotionDTO {

    private int userId;
    private int id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int categoryId;
    private double price;
    private Boolean hasPromo;
    private double discount;
}


