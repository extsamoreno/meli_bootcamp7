package com.meli.socialmeli.model.dto;

import com.meli.socialmeli.model.dao.model.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private int idPost;
    private String date;
    private Product detail;
    private int category;
    private double price;
}
