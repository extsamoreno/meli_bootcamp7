package com.meli.socialmeli.model.dao.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int userId;
    private int idPost;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
