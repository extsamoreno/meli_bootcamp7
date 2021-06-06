package com.linktracker.api.service;

import com.linktracker.api.dto.*;
import com.linktracker.api.repository.LinkTrackerRepositoryImple;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.URISyntaxException;
import com.linktracker.api.exception.*;

@Service
public class LinkTrackerServiceImple implements LinkTrackerService{

    @Autowired
    LinkTrackerRepositoryImple linkTrackerRepositoryImple;


    @Override
    public NewLinkResponseDTO addLink (NewLinkResquestDTO newLinkResquestDTO){

        UrlValidator validator = new UrlValidator();
        boolean noDuplicateUrl=true;
        //check for valid URL
        if (validator.isValid(newLinkResquestDTO.getUrl())) {

            //check for duplicated URL
            for (int i = 1; i <= linkTrackerRepositoryImple.getId(); i++) {
                if (newLinkResquestDTO.getUrl().equals(linkTrackerRepositoryImple.getLinkRepository().get(i).getUrl())){
                    noDuplicateUrl=false;
                }
            }

            if (noDuplicateUrl){
                LinkDTO linkDTO = new LinkDTO (newLinkResquestDTO.getUrl(), 0, true, newLinkResquestDTO.getPassword());
                linkTrackerRepositoryImple.setId(linkTrackerRepositoryImple.getId() + 1);
                linkTrackerRepositoryImple.getLinkRepository().put(linkTrackerRepositoryImple.getId(),linkDTO);
                return new NewLinkResponseDTO(linkTrackerRepositoryImple.getId(), newLinkResquestDTO.getUrl());
            } else{
                return new NewLinkResponseDTO(-1, "Duplicated URL");
            }

        }else{
            return new NewLinkResponseDTO(-1, "No valid URL");
        }
    }


    @Override
    public HttpHeaders redirectToUrl(int id, String password) throws LinkTrackerBadIdException, URISyntaxException, LinkTrackerBadPasswordException, LinkTrackerNoValidException {
        if (linkTrackerRepositoryImple.getLinkRepository().get(id)==null){
            throw new LinkTrackerBadIdException(id);
        }

        if (!linkTrackerRepositoryImple.getLinkRepository().get(id).isEnable()){
            throw new LinkTrackerNoValidException();
        }



        String url = linkTrackerRepositoryImple.getLinkRepository().get(id).getUrl();

        if (linkTrackerRepositoryImple.getLinkRepository().get(id).getPassword()==null){
            int redirectCounter = linkTrackerRepositoryImple.getLinkRepository().get(id).getRedirectCounter();
            linkTrackerRepositoryImple.getLinkRepository().get(id).setRedirectCounter(redirectCounter+1);
            URI site = new URI(url);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(site);
            return httpHeaders;
        }

        if (password==null){
            throw new LinkTrackerBadPasswordException();
        }

        if (password.equals(linkTrackerRepositoryImple.getLinkRepository().get(id).getPassword())){
            int redirectCounter = linkTrackerRepositoryImple.getLinkRepository().get(id).getRedirectCounter();
            linkTrackerRepositoryImple.getLinkRepository().get(id).setRedirectCounter(redirectCounter+1);
            URI site = new URI(url);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(site);
            return httpHeaders;
        } else{
            throw new LinkTrackerBadPasswordException();
        }
    }


    @Override
    public MetricsDTO metricsByID (int id) throws LinkTrackerBadIdException {
        if (linkTrackerRepositoryImple.getLinkRepository().get(id)==null){
            throw new LinkTrackerBadIdException(id);
        }
        String url = linkTrackerRepositoryImple.getLinkRepository().get(id).getUrl();
        int redirectCounter = linkTrackerRepositoryImple.getLinkRepository().get(id).getRedirectCounter();
        return new MetricsDTO(url, id, redirectCounter);
    }


    @Override
    public InvalidateDTO invalidateById (int id) throws LinkTrackerBadIdException {
        if (linkTrackerRepositoryImple.getLinkRepository().get(id)==null){
            throw new LinkTrackerBadIdException(id);
        }
        String url = linkTrackerRepositoryImple.getLinkRepository().get(id).getUrl();
        linkTrackerRepositoryImple.getLinkRepository().get(id).setEnable(false);
        return new InvalidateDTO(url, id, "No valid");
    }

}
