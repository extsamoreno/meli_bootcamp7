package com.spring.spring4;

import com.spring.spring4.Classes.Link;
import com.spring.spring4.DTOs.LinkDTO;

public class LinkMapper {
    public static LinkDTO getLinkDTO(Link url){
        return new LinkDTO(url.getId());
    }

    public static Link getLink(LinkDTO linkDTO){
        return new Link(linkDTO.getId());
    }
}
