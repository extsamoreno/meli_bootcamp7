package com.desafio_1.demo.dtos;

import com.desafio_1.demo.models.ProductDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBaseResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("id_post")
    private int idPost;
    private LocalDate date;
    private ProductDetailDTO detail;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
