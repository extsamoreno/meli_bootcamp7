package com.spring.desafioSpring.DTOs;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int userId;
    private int id_post;
    private LocalDate Date;
    private ProductDTO detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private double discount;
}


