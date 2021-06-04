package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkInvalidException;
import com.linktracker.demo.models.Link;
import com.linktracker.demo.repositories.ILinkRepository;
import com.linktracker.demo.services.mappers.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.UrlValidator;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException {
        LinkResponseDTO linkResponse = null;

        UrlValidator defaultValidator = new UrlValidator();
        boolean isUrlValid = defaultValidator.isValid(linkRequestDTO.getUrl());

        Link linkExist = linkRepository.findLinkByUrl(linkRequestDTO.getUrl());

        if(isUrlValid && linkExist == null){
            Link link = LinkMapper.toModel(linkRequestDTO);
            linkResponse = LinkMapper.toDTO(linkRepository.addLink(link));
        }
        else if(!isUrlValid){
            throw new LinkInvalidException(linkRequestDTO.getUrl());
        }
        else if(linkExist != null){
            throw new LinkAlreadyExistException(linkRequestDTO.getUrl());
        }


        return linkResponse;
    }

}
