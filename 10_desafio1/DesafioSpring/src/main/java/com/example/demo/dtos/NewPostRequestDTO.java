package com.example.demo.dtos;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostRequestDTO {
    private int userId;
    private int id_post;
    private String date;
    private DetailDTO detail;
    private int category;
    private double price;
}
