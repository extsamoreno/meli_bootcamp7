package com.meli.desafio1.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.desafio1.web.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTO
{
    private int userId;
    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
