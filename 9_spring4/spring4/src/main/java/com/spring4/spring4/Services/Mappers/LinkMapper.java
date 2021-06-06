package com.spring4.spring4.Services.Mappers;

import com.spring4.spring4.DTOs.LinkMetricDTO;
import com.spring4.spring4.DTOs.LinkRequestDTO;
import com.spring4.spring4.DTOs.LinkResponseDTO;
import com.spring4.spring4.Models.Link;

public class LinkMapper {
    public static Link linkDtoRequestCreateToLink(LinkRequestDTO linkDTO){
        Link link = new Link();
        link.setUrl(linkDTO.getUrl());
        link.setPass(linkDTO.getPass());

        return link;
    }

    public static LinkResponseDTO linkTolinkDtoResponseCreated(Link link){
        LinkResponseDTO linkDTO = new LinkResponseDTO();
        linkDTO.setId(link.getId());
        linkDTO.setUrl(link.getUrl());

        return linkDTO;
    }

    public static LinkMetricDTO linkToLinkMetricDto(Link link){
        LinkMetricDTO linkDTO = new LinkMetricDTO();
        linkDTO.setUrl(link.getUrl());
        linkDTO.setRedirections(link.getRedirections());
        linkDTO.setActive(link.getActive());

        return linkDTO;
    }

}
