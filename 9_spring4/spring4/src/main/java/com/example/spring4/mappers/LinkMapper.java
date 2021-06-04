package com.example.spring4.mappers;

import com.example.spring4.dtos.LinkStringDTO;
import com.example.spring4.models.Link;

public class LinkMapper {

    public static LinkStringDTO toDTO(Link link) {
        return new LinkStringDTO(link);
    }

    public static Link toObject(LinkStringDTO linkStringDTO) {
        return new Link(linkStringDTO);
    }

}
