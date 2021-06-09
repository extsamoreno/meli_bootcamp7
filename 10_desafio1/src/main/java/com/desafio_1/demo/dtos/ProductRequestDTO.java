package com.desafio_1.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private int userId;
    @JsonProperty("id_post")
    private int idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDetailDTO detail;
    private int category;
    private double price;
}
