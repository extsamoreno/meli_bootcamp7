package com.spring.desafioSpring.DTOs;

import com.spring.desafioSpring.Models.Product;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int userId;
    private int id_post;
    private LocalDate Date;
    private Product detail;
    private Integer category;
    private Double price;
}


