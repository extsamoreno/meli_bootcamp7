package com.desafiospring.socialMeli.dto;

import com.desafiospring.socialMeli.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO  {

    private int userId;
    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Product detail;
    private String category;
    private double price;

}