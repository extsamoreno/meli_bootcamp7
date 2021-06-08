package com.example.demo.services.mapper;

import com.example.demo.dto.LinkRequestDTO;
import com.example.demo.dto.LinkResponseDTO;
import com.example.demo.models.Link;

public class LinkMapper {

    public static LinkResponseDTO toDTO(Link link){
        return new LinkResponseDTO(link.getId(), link.getAddress(), link.isValid());
    }

    public static Link toModel(LinkRequestDTO link){
        return new Link(link.getAddress(), true, link.getPassword());
    }
}
