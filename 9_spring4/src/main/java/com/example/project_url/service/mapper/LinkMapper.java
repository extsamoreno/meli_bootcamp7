package com.example.project_url.service.mapper;

import com.example.project_url.models.Link;
import com.example.project_url.service.dto.LinkRequestDTO;
import com.example.project_url.service.dto.LinkResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper implements IGenericMapper<Link, LinkRequestDTO, LinkResponseDTO> {
    @Override
    public LinkRequestDTO toDto(Link model) {
        return new LinkRequestDTO(model.getUrl(), model.getPassword());
    }

    @Override
    public Link toModel(LinkRequestDTO dto) {
        Link link = new Link();

        link.setUrl(dto.getUrl());
        link.setPassword(dto.getPassword());

        return link;
    }

    @Override
    public LinkResponseDTO toDtoResponse(Link model) {
        return new LinkResponseDTO(model.getId(), model.getVisits());
    }
}
