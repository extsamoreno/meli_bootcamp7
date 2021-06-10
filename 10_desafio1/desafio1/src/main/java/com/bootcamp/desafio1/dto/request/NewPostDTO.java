package com.bootcamp.desafio1.dto.request;

import com.bootcamp.desafio1.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class NewPostDTO {

    private int userId;
    private int postId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
