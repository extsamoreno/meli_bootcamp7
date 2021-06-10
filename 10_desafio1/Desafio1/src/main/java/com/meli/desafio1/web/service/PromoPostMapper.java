package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.PromoPostDTO;
import com.meli.desafio1.web.model.Npost;

public class PromoPostMapper {

    public static Npost toModel(PromoPostDTO promoPostDTO){
        return new Npost(promoPostDTO.getUserId(),promoPostDTO.getId_post(),promoPostDTO.getDate(),promoPostDTO.getDetail(),promoPostDTO.getCategory(),promoPostDTO.getPrice(),promoPostDTO.isHasPromo(),promoPostDTO.getDiscount());
    }

    public static PromoPostDTO toDTO(Npost npost){
        return new PromoPostDTO(npost.getUserId(),npost.getId_post(),npost.getDate(),npost.getDetail(),npost.getCategory(),npost.getPrice(),npost.isHasPromo(),npost.getDiscount());
    }
}
