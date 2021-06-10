package com.desafio.socialMeli.service.dto;

import com.desafio.socialMeli.repository.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private Integer userId;
    private Integer id_post;
    private String date;//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Product detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private float discount;
}
