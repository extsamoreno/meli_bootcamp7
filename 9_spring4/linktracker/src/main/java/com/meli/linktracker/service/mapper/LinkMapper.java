package com.meli.linktracker.service.mapper;

import com.meli.linktracker.model.Link;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.MetricsDTO;

public class LinkMapper {

    public static LinkDTO toDTO(Link link){
        return new LinkDTO(link.getUrl(),link.getPassword());
    }

    public static Link toModel(LinkDTO linkDTO){
        return new Link(null, linkDTO.getUrl(), linkDTO.getPassword(),null, true);
    }

    public static MetricsDTO linkToMetricsDTO(Link link){
        return new MetricsDTO(link.getUrl(), link.getNumRedirections());
    }

}
