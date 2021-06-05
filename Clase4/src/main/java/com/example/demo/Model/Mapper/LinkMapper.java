package com.example.demo.Model.Mapper;

import com.example.demo.Model.DTO.DTORequest.LinkDTOResquest;
import com.example.demo.Model.DTO.DTOResponse.LinkDTOResponse;
import com.example.demo.Model.Link;
import com.example.demo.Repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LinkMapper {

    public static LinkDTOResponse toDTO(Link link){
        return new LinkDTOResponse(link.getId());
    }

    public static Link toLink(LinkDTOResquest linkDTOResquest, int size){
        return new Link(size,linkDTOResquest.getLink(),0,
                        true);
    }

}
