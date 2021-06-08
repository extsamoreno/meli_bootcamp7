package com.meli.socialmeli.model.dao.model;

import lombok.*;
import java.util.Date;
import java.util.Formatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int idPost;
    private Date date;
    private Product detail;
    private int category;
    private double price;
}
