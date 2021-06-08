package com.meli.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int userId;
    private int id_post;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
