package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {

    private int userId;
    private int idPost;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private ProductDetailDTO detail;
    private int category;
    private double price;

}
