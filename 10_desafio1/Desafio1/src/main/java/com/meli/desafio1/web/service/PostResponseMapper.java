package com.meli.desafio1.web.service;

import com.meli.desafio1.web.model.Npost;
import com.meli.desafio1.web.response.PostResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PostResponseMapper {
    public static PostResponse toDTO(Npost npost){
        return new PostResponse(npost.getId_post(),npost.getDate(), ProductMapper.toDTO(npost.getDetail()),npost.getCategory(),npost.getPrice(),npost.isHasPromo(),npost.getDiscount());
    }
}
