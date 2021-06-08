package com.bootcamp.linktracker.mapper;

import com.bootcamp.linktracker.dto.InvalidateLinkResponseDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.MetricsDTO;
import com.bootcamp.linktracker.model.Link;

public class LinkMapper {
    public static LinkResponseDTO toLinkResponseDTO(Link link) {
        return new LinkResponseDTO(link.getId());
    }

    public static MetricsDTO toMetricsDTO(Link link) {
        return new MetricsDTO(link.getTotalRedirects(), link.getUrl(), link.getId());
    }

    public static InvalidateLinkResponseDTO toInvalidateResponseDTO(Link link) {
        return new InvalidateLinkResponseDTO(link.getUrl());
    }
}
