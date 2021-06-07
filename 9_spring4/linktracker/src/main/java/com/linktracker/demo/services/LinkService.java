package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkReportDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;
import com.linktracker.demo.models.Link;
import com.linktracker.demo.repositories.ILinkRepository;
import com.linktracker.demo.services.mappers.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.UrlValidator;

import java.util.Objects;
import java.util.Scanner;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkURLNotValidException, LinkAlreadyExistException {
        LinkResponseDTO linkResponse = null;
        UrlValidator defaultValidator = new UrlValidator();

        if(!defaultValidator.isValid(linkRequestDTO.getUrl())){
            throw new LinkURLNotValidException(linkRequestDTO.getUrl());
        }
        if(linkRepository.findLinkByUrl(linkRequestDTO.getUrl()) != null){
            throw new LinkAlreadyExistException(linkRequestDTO.getUrl());
        }

        Link link = LinkMapper.toModel(linkRequestDTO);

        linkResponse = LinkMapper.toDTO(linkRepository.addLink(link));

        linkRepository.log();
        return linkResponse;
    }

    @Override
    public String getLink(int linkID, String pass) throws LinkIDNotValidException, PasswordAuthenticationFailedException {
        Link link = linkRepository.findLinkByID(linkID);
        linkRepository.log();

        if(link == null || !linkRepository.isLinkActive(linkID))
            throw new LinkIDNotValidException(linkID);

        if(!Objects.equals(link.getPassword(), pass))
            throw new PasswordAuthenticationFailedException();

        linkRepository.incrementLinkReport(linkID);
        return link.getUrl();
    }

    @Override
    public LinkReportDTO getLinkReport(int linkID) throws LinkIDNotValidException {
        linkRepository.log();

        if(linkRepository.findLinkByID(linkID) == null)
            throw  new LinkIDNotValidException(linkID);

        return new LinkReportDTO(linkRepository.getLinkReport(linkID));
    }

    @Override
    public String invalidateLink(int linkID) throws ResponseException {
        linkRepository.log();

        if(!linkRepository.invalidateLink(linkID))
            throw new ResponseException("There was a problem whilst invalidating the link ID " + linkID, HttpStatus.BAD_REQUEST);
        return "Link ID " + linkID + " invalidated successfully!";
    }


}
