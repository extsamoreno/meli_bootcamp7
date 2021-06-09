package com.example.desafio1.services.mappers;

import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.models.Publishing;

import java.util.ArrayList;
import java.util.List;

public class PublishingMapper {
    public static Publishing toModel(PublishingDTO pubDTO) {
        Publishing pub = new Publishing();
        pub.setIdPost(pubDTO.getIdPost());
        pub.setCategory(pubDTO.getCategory());
        pub.setDate(pubDTO.getDate());
        pub.setDetail(ProductMapper.toModel(pubDTO.getDetail()));
        pub.setUserId(pubDTO.getUserId());
        pub.setPrice(pubDTO.getPrice());

        return pub;
    }

    public static List<PublishingDTO> toDTOList(List<Publishing> pubList){
        List<PublishingDTO> pubDTOList = new ArrayList<>();
        PublishingDTO pubDTO;
        for (Publishing publishing : pubList) {
            pubDTO = new PublishingDTO();
            pubDTO.setIdPost(publishing.getIdPost());
            pubDTO.setDate(publishing.getDate());
            pubDTO.setCategory(publishing.getCategory());
            pubDTO.setDetail(ProductMapper.toDTO(publishing.getDetail()));
            pubDTO.setPrice(publishing.getPrice());
            pubDTO.setUserId(publishing.getUserId());
            pubDTOList.add(pubDTO);
        }
        return pubDTOList;
    }
}
