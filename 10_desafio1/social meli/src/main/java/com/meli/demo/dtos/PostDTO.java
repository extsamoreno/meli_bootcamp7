package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int userId;
    private int id_post;
    private String date;
    private DetailDTO detail;
    private Integer category;
    private Double price;

}

