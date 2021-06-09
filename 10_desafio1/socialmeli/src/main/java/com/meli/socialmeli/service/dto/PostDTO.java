package com.meli.socialmeli.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Integer userId;
    private Integer postId;
    private String date;
    private ProductDTO detail;
    private Integer category;
    private Double price;

}
