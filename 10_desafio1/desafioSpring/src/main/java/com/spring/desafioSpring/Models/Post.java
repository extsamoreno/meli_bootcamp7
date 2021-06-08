package com.spring.desafioSpring.Models;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int id_post;
    private LocalDate Date;
    private Product detail;
    private Integer category;
    private Double price;
}
