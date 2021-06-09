package com.example.socialmeli.models.dtos.request;

import com.example.socialmeli.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class NewPostRequestDTO {
    private int userId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
}
