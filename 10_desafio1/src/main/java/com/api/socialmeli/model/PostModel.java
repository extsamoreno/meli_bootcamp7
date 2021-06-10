package com.api.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PostModel {
    private int userId;
    private int id_post;
    private LocalDate date;
    private ProductModel detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
