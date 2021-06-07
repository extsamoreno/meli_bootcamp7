package com.meli.spring.services.mapper;

import com.meli.spring.models.Link;
import com.meli.spring.services.dto.LinkDto;


public class LinkMapper {
    public static LinkDto toDTO(Link link){
        return new LinkDto(link.getLinkID(), link.getUrl());
    }
}
