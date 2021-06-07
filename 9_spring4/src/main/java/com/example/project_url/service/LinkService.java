package com.example.project_url.service;

import com.example.project_url.exception.*;
import com.example.project_url.models.Link;
import com.example.project_url.repository.ILinkRepository;
import com.example.project_url.service.dto.LinkRequestDTO;
import com.example.project_url.service.dto.LinkResponseDTO;
import com.example.project_url.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URL;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    @Autowired
    LinkMapper linkMapper;

    @Override
    public LinkResponseDTO create(LinkRequestDTO requestModel) throws LinkExceptionInvalidUrl, LinkExceptionEmptyUrl, LinkExceptionAlreadyExists {

        Link newLink = linkMapper.toModel(requestModel);

        validateLink(newLink);

        validateExists(newLink);

        newLink.setActive(true);

        linkRepository.create(newLink);

        return linkMapper.toDtoResponse(newLink);
    }

    @Override
    public ResponseEntity<Void> redirect(int linkId, String password) throws LinkExceptionInvalidPassword, LinkExceptionNotExists, LinkExceptionInactive {
        Link link = this.getById(linkId);

        if (!isValidPassword(link, password)) {//If is not valid, throw exception
            throw new LinkExceptionInvalidPassword();
        }

        link.addVisit();

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link.getUrl())).build();
    }

    @Override
    public LinkResponseDTO metrics(int linkId) throws LinkExceptionNotExists, LinkExceptionInactive {
        Link link = this.getById(linkId);
        return linkMapper.toDtoResponse(link);
    }

    @Override
    public void invalidate(int linkId) throws LinkExceptionNotExists, LinkExceptionInactive {
        Link link = this.getById(linkId);
        linkRepository.invalidate(link);
    }


    //private methods
    private boolean isValidPassword(Link link, String password) {
        return link.getUrl().isEmpty() || link.getPassword().equals(password);
    }

    //Validate consistency of the data
    private void validateLink(Link link) throws LinkExceptionInvalidUrl, LinkExceptionEmptyUrl {
        isEmptyUrl(link);
        isValidUrl(link);
    }

    private boolean isEmptyUrl(Link link) throws LinkExceptionEmptyUrl {
        if (link.getUrl().isEmpty()) {
            throw new LinkExceptionEmptyUrl();
        }
        return true;
    }

    //If the url is valid, returns true, if not, throw exception
    private boolean isValidUrl(Link link) throws LinkExceptionInvalidUrl {

        try {
            URL url = new URL(link.getUrl()); //This check for valid protocol
            url.toURI(); //This check for the url malformation or something
        } catch (Exception _e) {
            throw new LinkExceptionInvalidUrl();
        }

        return true;
    }

    private Link getById(int linkId) throws LinkExceptionNotExists, LinkExceptionInactive {
        Link linkAux = linkRepository.getById(linkId);
        if (linkAux == null) {
            throw new LinkExceptionNotExists(linkId);
        }

        if(!linkAux.isActive()) {
            throw new LinkExceptionInactive(linkId);
        }
        return linkAux;
    }

    private boolean validateExists(Link link) throws LinkExceptionAlreadyExists {
        Link linkAux = linkRepository.getByUrl(link.getUrl());
        if (linkAux != null) {
            throw new LinkExceptionAlreadyExists(link.getUrl());
        }
        return true;
    }
}
