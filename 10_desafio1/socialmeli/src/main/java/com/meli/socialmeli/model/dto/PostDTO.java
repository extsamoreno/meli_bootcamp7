package com.meli.socialmeli.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.model.dao.model.Product;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private int idPost;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String date;
    private Product detail;
    private int category;
    private double price;
}
