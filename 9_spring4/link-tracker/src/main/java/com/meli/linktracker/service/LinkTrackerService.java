package com.meli.linktracker.service;

import com.meli.linktracker.model.Link;
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
    public LinkResponseDTO createLink(LinkRequestDTO body) throws InvalidURLException {
        Link link = new Link(createURI(body.getUrl()), body.getPassword());
        Integer id = linkTrackerRepository.save(link);
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
    public URI findURIByLinkId(Integer linkId) throws IdNotFoundException, InvalidURLException {
        Link link = linkTrackerRepository.getLinkByID(linkId);
        addARedirect(linkId);
        if (link.getPassword() != null) return addQueryParamPassword(link);
        else return link.getUri();
    }

    private URI addQueryParamPassword(Link link) throws InvalidURLException {
        String appendQuery = "password=" + link.getPassword();
        return addQueryParam(link.getUri(), appendQuery);
    }

    private URI addQueryParam(URI baseUri, String appendQuery) throws InvalidURLException {
        try {
            String newQuery = baseUri.getQuery();
            if (newQuery == null) {
                newQuery = appendQuery;
            } else {
                newQuery += "&" + appendQuery;
            }
            return new URI(baseUri.getScheme(), baseUri.getAuthority(),
                    baseUri.getPath(), newQuery, baseUri.getFragment());
        } catch (Exception e) {
            throw new InvalidURLException(baseUri.getRawPath());
        }
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
                    LinkResponseDTO linkDTO;
                    try {
                        linkDTO = createLink(l);
                    } catch (InvalidURLException e) {
                        linkDTO = new LinkResponseDTO(-1);
                    }
                    return linkDTO;
                })
                .collect(Collectors.toList());
    }
}
