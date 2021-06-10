package com.example.demo.DTO;

import com.example.demo.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO {

    private int id_post;
    private Date date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
