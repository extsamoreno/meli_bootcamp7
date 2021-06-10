package com.linktracker.demo.services.mappers;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.models.Link;

import java.util.ArrayList;

public class LinkMapper {

    public static LinkResponseDTO toDTO(Link link){
        return new LinkResponseDTO(link.getId(), link.getUrl(), link.isValid());
    }

    public static Link toModel(LinkRequestDTO link){
        return new Link(link.getUrl(), true, link.getPassword());
    }
}