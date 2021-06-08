package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.PublishingDTORequest;
import com.example.desafio1.models.Publishing;

public class PublishingMapper {
    public static Publishing toModel(PublishingDTORequest pubDTO) {
        Publishing pub = new Publishing();
        pub.setIdPost(pubDTO.getIdPost());
        pub.setCategory(pubDTO.getCategory());
        pub.setDate(pubDTO.getDate());
        pub.setDetail(ProductMapper.toModel(pubDTO.getDetail()));
        pub.setUserId(pubDTO.getUserId());
        pub.setPrice(pubDTO.getPrice());

        return pub;
    }
}
