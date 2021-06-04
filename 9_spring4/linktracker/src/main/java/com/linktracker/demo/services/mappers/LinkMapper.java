package com.linktracker.demo.services.mappers;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.models.Link;

public class LinkMapper {

    public static LinkResponseDTO toDTO(Link link){
        return new LinkResponseDTO(link.getId());
    }

    public static Link toModel(LinkRequestDTO link){
        return new Link(link.getUrl());
    }
}
