package com.example.desafio1.service.dto.post;

import com.example.desafio1.model.ProductDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePromoPostDTO {

    private int postId;

    private @JsonFormat(pattern = "dd-MM-yyyy")
    Date date;

    private ProductDetail detail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
