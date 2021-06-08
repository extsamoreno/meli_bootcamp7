package com.example.linktracker.service.mapper;

import com.example.linktracker.model.Link;
import com.example.linktracker.service.dto.ResponseLinkDTO;

public class LinkResponseMapper {

    public static ResponseLinkDTO toLinkDTO(Link link) {

        ResponseLinkDTO response = new ResponseLinkDTO();
        response.setId(link.getId());
        response.setUrl(link.getUrl());
        response.setConsultTimes(link.getConsultTimes());
        response.setActive(link.isActive());

        return response;
    }

    public static Link toLink(ResponseLinkDTO link) {

        Link newLink = new Link();
        newLink.setId(link.getId());
        newLink.setUrl(link.getUrl());

        return newLink;
    }
}
