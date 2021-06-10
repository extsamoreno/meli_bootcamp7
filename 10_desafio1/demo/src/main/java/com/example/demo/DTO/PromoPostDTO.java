package com.example.demo.DTO;

import lombok.Data;

@Data
public class PromoPostDTO extends PostDTO{

    private boolean hasPromo;
    private double discount;

}
