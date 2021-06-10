package com.socialmeli.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class PromoListSellerDTO {

    private int userId;
    private String userName;
    private ArrayList<PostPromoDTO> posts;

}
