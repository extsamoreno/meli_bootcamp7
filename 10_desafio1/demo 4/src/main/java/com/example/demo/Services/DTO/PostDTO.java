package com.example.demo.Services.DTO;


import com.example.demo.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private int id_post;
    private Date date;
    private Product detail;
    private int category;
    private double price;

}
