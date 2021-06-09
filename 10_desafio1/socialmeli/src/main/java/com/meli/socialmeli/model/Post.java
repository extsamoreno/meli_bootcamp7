package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Integer postId;
    private Integer userId;
    private String dateCreation;
    private String dateModification;
    private Integer categoryId;
    private Product product;
    private double price;
    private boolean hasPromo;
    private double discount;

}
