package com.linkTracker;

import com.exceptions.HandlerException;
import com.exceptions.InvalidUrlException;
import com.linkTracker.repository.iLinkTrackerRepository;
import com.models.LinkDTO;
import com.models.UrlDTO;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class LinkTrackerService implements iLinkTrackerService{

    @Autowired
    iLinkTrackerRepository repository;
    @Autowired
    HandlerException handlerException;

    private UrlValidator urlValidator = new UrlValidator();

    @Override
    public UrlDTO createLink (String url) throws InvalidUrlException {
        UrlDTO urlDTO = new UrlDTO();
        if (validateUrl(url))
            urlDTO = repository.saveLink(url);
        else
            throw new InvalidUrlException(url);
        return urlDTO;
    }

    @Override
    public UrlDTO createLink (String url, String password) {
        UrlDTO urlDTO = new UrlDTO();
        if (validateUrl(url)){
            urlDTO = repository.saveLink(url, password);
        }
        return urlDTO;
    }

    public boolean validateUrl (String url) {
        return urlValidator.isValid(url);
    }

    @Override
    public LinkDTO redirect (Integer linkId){
        LinkDTO linkDTO = repository.getLinkDto(linkId);
        linkDTO.setTimesAccessed(linkDTO.getTimesAccessed()+1);
        return linkDTO;
    }

    @Override
    public LinkDTO redirect (Integer linkId, String password){
        LinkDTO linkDTO = repository.getLinkDto(linkId);
        if (linkDTO.getPassword().equals(password)){
            linkDTO.setTimesAccessed(linkDTO.getTimesAccessed()+1);
            return linkDTO;
        }
        return null;
    }

    @Override
    public Integer calculateRedirectionMetrics(Integer linkId) {
        return repository.getLinkDto(linkId).getTimesAccessed();
    }

    @Override
    public LinkDTO invalidateLink (Integer linkId){
        LinkDTO linkDTO = repository.getLinkDto(linkId);
        linkDTO.setEnabled(false);
        return linkDTO;
    }

}
