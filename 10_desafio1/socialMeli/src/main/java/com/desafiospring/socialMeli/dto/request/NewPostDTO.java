package com.desafiospring.socialMeli.dto.request;

import com.desafiospring.socialMeli.model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPostDTO {

    private int userId;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Product detail;
    private String category;
    private double price;

}
