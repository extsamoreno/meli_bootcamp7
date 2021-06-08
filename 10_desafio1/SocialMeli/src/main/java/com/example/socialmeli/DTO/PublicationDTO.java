package com.example.socialmeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {
    private int id_post;
    private int userId;
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
