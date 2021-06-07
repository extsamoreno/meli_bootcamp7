package com.example.springboot.mappers;

import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.models.Link;

public class LinkMapper {

    public static LinkStringDTO toDTO(Link link) {
        return new LinkStringDTO(link);
    }

    public static Link toObject(LinkStringDTO linkStringDTO) {
        return new Link(linkStringDTO);
    }

}
