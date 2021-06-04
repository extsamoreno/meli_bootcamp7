package com.meli.linktracker.service;

import com.meli.linktracker.domain.Link;
import com.meli.linktracker.dto.LinkMetricRequestDTO;
import com.meli.linktracker.dto.LinkRequestDTO;
import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;
import com.meli.linktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkTrackerService implements ILinkTrackerService {
    @Autowired
    ILinkTrackerRepository linkTrackerRepository;

    @Override
    public LinkResponseDTO createLink(String url) throws InvalidURLException {
        Integer id = linkTrackerRepository.save(createURI(url));
        return new LinkResponseDTO(id);
    }

    private URI createURI(String url) throws InvalidURLException {
        try {
            return new URL(url).toURI();
        } catch (Exception e) {
            throw new InvalidURLException(url);
        }
    }

    @Override
    public URI findURIByLinkId(Integer linkId) throws IdNotFoundException {
        Link link = linkTrackerRepository.getLinkByID(linkId);
        addARedirect(linkId);
        return link.getUri();
    }

    private void addARedirect(Integer linkId) throws IdNotFoundException {
        linkTrackerRepository.addRedirect(linkId);
    }

    @Override
    public LinkMetricRequestDTO findMetricsByLinkId(Integer linkId) throws IdNotFoundException {
        Link link = linkTrackerRepository.getLinkByID(linkId);
        return new LinkMetricRequestDTO(linkId, link.getRedirects());
    }

    @Override
    public void invalidateByLinkId(Integer linkId) throws IdNotFoundException {
        linkTrackerRepository.invalidateByLinkId(linkId);
    }

    @Override
    public List<LinkResponseDTO> createLinkMultiple(List<LinkRequestDTO> list) {
        return list.stream().map(
                l -> {
                    LinkResponseDTO link;
                    try {
                        link = createLink(l.getUrl());
                    } catch (InvalidURLException e) {
                        link = new LinkResponseDTO(-1);
                    }
                    return link;
                })
                .collect(Collectors.toList());
    }


}
