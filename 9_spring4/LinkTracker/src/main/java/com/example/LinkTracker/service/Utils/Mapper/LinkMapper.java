package com.example.LinkTracker.service.Utils.Mapper;

import com.example.LinkTracker.models.Link;
import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;
import jdk.dynalink.linker.LinkRequest;

public class LinkMapper {
    public static Link mapToLinkResponseDTO(LinkDTORequest request){
        return new Link(request.getLink(),request.getPassword());
    }
}
