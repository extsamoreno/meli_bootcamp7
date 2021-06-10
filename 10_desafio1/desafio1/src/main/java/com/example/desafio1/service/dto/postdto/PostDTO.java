package com.example.desafio1.service.dto.postdto;

import com.example.desafio1.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO
{
    private int userId;
    private int id_post;
    private String date;
    private Product detail;
    private int category;
    private double price;

}
