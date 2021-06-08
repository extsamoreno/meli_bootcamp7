package com.example.linktracker.service.mapper;

import com.example.linktracker.model.Link;
import com.example.linktracker.service.dto.LinkDTO;

public class LinkMapper {

    public static LinkDTO toLinkDTO(Link link) {

        LinkDTO newLinkDTO = new LinkDTO();
        newLinkDTO.setPassword(link.getPassword());
        newLinkDTO.setUrl(link.getUrl());

        return newLinkDTO;
    }

    public static Link toLink(LinkDTO link) {

        Link newLink = new Link();
        newLink.setUrl(link.getUrl());
        newLink.setPassword(link.getPassword());

        return newLink;
    }
}
