package com.api.apiMask.service.mapper;

import com.api.apiMask.controller.dto.response.LinkDTO;
import com.api.apiMask.repository.entity.Link;

public class LinkMapper {
    public static LinkDTO toDTO(Link entity){
        return new LinkDTO(entity.getUrl(), entity.getLinkId());
    }
}
