package com.meli.linktracker.service;

import com.meli.linktracker.exception.LinkExceptionBadURL;
import com.meli.linktracker.exception.LinkExceptionURLEmpty;
import com.meli.linktracker.exception.LinkExceptionURLInactive;
import com.meli.linktracker.exception.LinkExceptionURLNotExists;
import com.meli.linktracker.model.Link;
import com.meli.linktracker.repository.ILinkRepository;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;
import com.meli.linktracker.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.LinkException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkServiceImp implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkResponseDto createLink(LinkDTO link) throws LinkExceptionURLEmpty, LinkExceptionBadURL {
        if (link.getUrl() == null || link.getUrl().compareTo("") == 0) {
            throw new LinkExceptionURLEmpty();
        }
        if (!urlValidator(link.getUrl())) {
            throw new LinkExceptionBadURL();
        }
        Link searchedLink = getLinkByUrl(link.getUrl());
        LinkResponseDto result = new LinkResponseDto();
        if (searchedLink == null) {
            Link parseLink = LinkMapper.toModel(link);
            linkRepository.save(parseLink);
            result.setLinkId(parseLink.getId());
            return result;
        }
        result.setLinkId(searchedLink.getId());
        return result;
    }

    @Override
    public LinkDTO getUrlById(Integer id) throws LinkExceptionURLNotExists, LinkExceptionURLInactive {
        Link model = linkRepository.findById(id);
        if (model == null) {
            throw new LinkExceptionURLNotExists(id);
        }
        if (!model.isActive()) {
            throw new LinkExceptionURLInactive(model.getId());
        }

        Integer numredirections = model.getNumRedirections() + 1;
        model.setNumRedirections(numredirections);
        linkRepository.updateLink(model);
        return LinkMapper.toDTO(model);
    }

    @Override
    public MetricsDTO getMetricsByLinkId(Integer id) {
        Link link = linkRepository.findById(id);
        return LinkMapper.linkToMetricsDTO(link);
    }

    @Override
    public LinkResponseDto invalidateLinkById(Integer id) {
        Link model = linkRepository.findById(id);
        if (model != null) {
            model.setActive(false);
            linkRepository.updateLink(model);
        }
        return new LinkResponseDto(model.getId());
    }

    private Link getLinkByUrl(String url) {
        Link link = linkRepository.findByUrl(url);
        return linkRepository.findByUrl(url);
    }

    private boolean urlValidator(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (URISyntaxException exception) {
            return false;
        } catch (MalformedURLException exception) {
            return false;
        }
    }

    private boolean validatePasswordLink(Link link, String password) {
        if (link.getPassword().compareTo(password) == 0) {
            return true;
        }
        return false;
    }

}
