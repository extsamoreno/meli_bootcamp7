package com.example.desafio1.service.dto.productdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostDTO
{
    private int id_post;
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;

}
