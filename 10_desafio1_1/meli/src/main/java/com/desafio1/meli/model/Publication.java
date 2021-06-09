package com.desafio1.meli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private Integer user_id;
    private User id_post;
    private Date date;
    private Product product;
    private Category category;
    private Double price;
}
