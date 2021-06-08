package com.spring4.ejercicios.link.service;

import com.spring4.ejercicios.link.model.Link;
import com.spring4.ejercicios.link.service.dto.request.LinkDTO;
import com.spring4.ejercicios.link.service.dto.response.IdDTO;
import com.spring4.ejercicios.link.service.dto.response.MetricsDTO;

public abstract class Mapper {

    public static Link toLink(LinkDTO linkDTO){
        String url = linkDTO.getUrl();
        String password = linkDTO.getPassword();
        Link newLink = new Link(url, password);
        return newLink;
    }

    public static IdDTO toIdDTO(Link link){
        String url = link.getLinkURL();
        Integer id = link.getLinkId();
        IdDTO newIdDTO = new IdDTO(url, id);
        return newIdDTO;
    }

    public static MetricsDTO toMetricsDTO(Link link){
        String url = link.getLinkURL();
        Integer views = link.getLinkViews();
        MetricsDTO newMetricsDTO = new MetricsDTO(url, views);
        return newMetricsDTO;
    }

}
