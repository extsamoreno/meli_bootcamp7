package com.ejercitacion.ejercitacion.service;

import com.ejercitacion.ejercitacion.dto.LinkIdResponse;
import com.ejercitacion.ejercitacion.dto.LinkRedirectionStadisticsResponse;
import com.ejercitacion.ejercitacion.dto.StoreLinkRequest;
import com.ejercitacion.ejercitacion.entity.StoredLink;
import com.ejercitacion.ejercitacion.exception.InvalidLinkPasswordException;
import com.ejercitacion.ejercitacion.exception.LinkException;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;
import com.ejercitacion.ejercitacion.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public LinkIdResponse storeNewLink(StoreLinkRequest request) throws LinkException {
        try {
            new URL(request.getUrl()).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new LinkException("The specified link + " + request.getUrl() + "is not a valid URL", HttpStatus.BAD_REQUEST);
        }
        return StoredLinkMapper.toLinkIdResponse(linkRepository.storeNewLink(StoredLinkMapper.toEntity(request)));
    }

    @Override
    public String getRequestedLinkForRedirection(Integer id, String password) throws LinkException {
        StoredLink sl = linkRepository.getStoredLinkById(id);
        if (sl.isValid()) {
            if (sl.getPassword() != null) {
                if (!sl.getPassword().equals(password)) {
                    throw new InvalidLinkPasswordException();
                }
            }
            if (sl.getUrl() != null) {
                linkRepository.incrementRedirectionCounterById(id);
                return sl.getUrl();
            } else {
                throw new LinkIdNotFoundException(id);
            }
        } else {
            throw new LinkException("Link not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void invalidateLink(Integer id) throws LinkIdNotFoundException {
       boolean invalidated = linkRepository.invalidateLinkById(id);
       if (!invalidated)
           throw new LinkIdNotFoundException(id);
    }

    @Override
    public LinkRedirectionStadisticsResponse getRedirectionsStadistics(Integer id) throws LinkIdNotFoundException {
        StoredLink sl = linkRepository.getStoredLinkById(id);
        if (sl != null) {
            return StoredLinkMapper.toRedirectionStadisticsResponse(sl);
        } else {
            throw new LinkIdNotFoundException(id);
        }
    }
}
