package com.spring4.linktracker.service.mapper;

import com.spring4.linktracker.service.dtos.LinkDTO;

public class LinkMapper {
    public static LinkDTO toDto (String url) {
        return new LinkDTO(url);
    }
}
