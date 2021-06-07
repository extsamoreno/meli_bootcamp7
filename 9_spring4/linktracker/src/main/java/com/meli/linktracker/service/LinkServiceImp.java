package com.meli.linktracker.service;

import com.meli.linktracker.model.Link;
import com.meli.linktracker.repository.ILinkRepository;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;
import com.meli.linktracker.service.mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImp implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkResponseDto createLink(LinkDTO link) {
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
    public LinkDTO getUrlById(Integer id) {
        Link model = linkRepository.findById(id);
        if (model != null && model.isActive()) {
            Integer numredirections = model.getNumRedirections() + 1;
            model.setNumRedirections(numredirections);
            linkRepository.updateLink(model);
            return LinkMapper.toDTO(model);
        }
        return null;
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
        return linkRepository.findByUrl(url);
    }

}
