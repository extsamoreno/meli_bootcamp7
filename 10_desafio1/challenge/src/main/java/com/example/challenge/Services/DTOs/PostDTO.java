package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

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


}
