package com.example.demo.socialmeli.models;

import com.example.demo.socialmeli.models.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Publication {
    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
