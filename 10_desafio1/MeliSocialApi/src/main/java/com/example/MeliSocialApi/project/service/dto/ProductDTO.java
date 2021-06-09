package com.example.MeliSocialApi.project.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer userId, idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private ProductDetailDTO detail;
    private Integer category;
    private double price;
}
