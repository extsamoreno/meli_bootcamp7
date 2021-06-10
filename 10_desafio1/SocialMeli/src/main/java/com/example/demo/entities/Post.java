package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;


}
