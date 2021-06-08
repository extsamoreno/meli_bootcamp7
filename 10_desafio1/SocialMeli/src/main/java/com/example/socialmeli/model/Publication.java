package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private int id_post;
    private int userId;
    private Date date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
