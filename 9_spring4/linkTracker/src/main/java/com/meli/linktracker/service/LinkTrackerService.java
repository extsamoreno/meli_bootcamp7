package com.meli.linktracker.service;

import com.meli.linktracker.domain.Link;
import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;
import com.meli.linktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URL;

@Service
public class LinkTrackerService implements ILinkTrackerService {
    @Autowired
    ILinkTrackerRepository linkTrackerRepository;

    @Override
    public LinkResponseDTO createLink(String url) throws InvalidURLException {
        URI newURI = null;
        try {
            newURI = new URL(url).toURI();
        } catch (Exception e) {
            throw new InvalidURLException(url);
        }

        Integer id = linkTrackerRepository.create(newURI);

        return new LinkResponseDTO(id);
    }

    @Override
    public URI findURIByLinkId(Integer linkId) throws IdNotFoundException {

        URI uri = linkTrackerRepository.getURIByID(linkId);
        if (uri == null) throw new IdNotFoundException(linkId);
        return uri;
    }
}
