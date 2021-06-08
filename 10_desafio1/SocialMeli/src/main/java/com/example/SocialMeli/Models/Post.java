package com.example.SocialMeli.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Post {

    private int id;
    private String name;
    private LocalDate date;
    private String product_id;
    private double price;


}
