package com.example.demo.Entities;

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
    private Date date;
    private Product detail;
    private int category;
    private double price;

}
