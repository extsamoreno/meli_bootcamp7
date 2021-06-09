package com.example.MeliSocialApi.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
    private Integer productId;
    private String productName, type, brand, color, notes;
}