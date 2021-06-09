package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostResponseDTO {
    private int userId;
    private int id_post;
    private String date;
    private DetailDTO detail;
    private int category;
    private double price;
}
