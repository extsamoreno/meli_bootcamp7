package com.meli.linktracker.service.mapper;

import com.meli.linktracker.model.Link;
import com.meli.linktracker.service.dto.LinkDTORequest;
import com.meli.linktracker.service.dto.LinkDTOResponse;

public class LinkMapper {
    public static Link toLink(LinkDTORequest link){
        Link newLink = new Link();
        newLink.setUrl(link.getUrl());
        newLink.setPassword(link.getPassword());
        return newLink;
    }

    public static LinkDTOResponse toLinkResponse(Link link){
        LinkDTOResponse newLink= new LinkDTOResponse();
        newLink.setLinkId(link.getId());
        return newLink;
    }
}
