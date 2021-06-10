package com.socialmeli.desafio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmeli.desafio.model.DetailModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class PostPromoDTO {

    private int userId;
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private DetailModel detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
