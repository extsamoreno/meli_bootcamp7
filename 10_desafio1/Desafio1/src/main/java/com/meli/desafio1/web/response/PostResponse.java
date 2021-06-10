package com.meli.desafio1.web.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.desafio1.web.dto.ProductDTO;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private int id_post;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private String category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
