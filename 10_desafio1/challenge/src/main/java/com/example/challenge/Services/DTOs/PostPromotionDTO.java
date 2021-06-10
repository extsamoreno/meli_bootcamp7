package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"userId", "id", "date", "product", "categoryId", "price", "hasPromo", "discount"})
public class PostPromotionDTO {

    private int userId;
    @JsonProperty("id_post")
    private int id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("detail")
    private ProductDTO product;
    @JsonProperty("category")
    private int categoryId;
    private double price;
    private Boolean hasPromo;
    private double discount;

}


