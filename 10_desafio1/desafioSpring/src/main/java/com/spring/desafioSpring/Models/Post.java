package com.spring.desafioSpring.Models;

import lombok.*;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer userId;
    private Integer id_post;
    private LocalDate Date;
    private Product detail;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private double discount;
}
