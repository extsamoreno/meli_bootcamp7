package com.bootcamp.desafio1.dto.response;

import com.bootcamp.desafio1.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PostDTO {

    private int postId;
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
