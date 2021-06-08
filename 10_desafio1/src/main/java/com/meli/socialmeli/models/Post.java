package com.meli.socialmeli.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private ProductDetail detail;
    private int category;
    private double price;

}
