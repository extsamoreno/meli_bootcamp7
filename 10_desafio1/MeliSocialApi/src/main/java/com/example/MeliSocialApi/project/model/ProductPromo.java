package com.example.MeliSocialApi.project.model;

import com.example.MeliSocialApi.project.service.dto.ProductDetailDTO;
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
public class ProductPromo extends Product{
    private Boolean hasPromo = false;
    private float discount;
    public ProductPromo(Integer userId, Integer idPost, Date date, ProductDetails details, Integer category, double price, Boolean hasPromo, float discount) {
        super(userId,idPost,date,details,category,price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}

