package com.spring4.linktracker.service;

import com.spring4.linktracker.exception.TrackerIdNotFoundException;
import com.spring4.linktracker.service.dtos.LinkDTO;
import com.spring4.linktracker.service.dtos.LinkListDTO;
import com.spring4.linktracker.service.mapper.LinkMapper;
import com.spring4.linktracker.service.utils.LinkUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class TrackerServiceImpl implements TrackerService {

    @Override
    public LinkDTO generateLink(String url) {
        LinkDTO link = LinkMapper.toDto(url);
        LinkListDTO.addLink(link);
        return link;
    }

    @Override
    public List<LinkDTO> allLinks() {
        return LinkListDTO.linksList;
    }

    @Override
    public ResponseEntity<Void> redirectLink(int id) throws TrackerIdNotFoundException {
        List<LinkDTO> links = LinkListDTO.linksList;
        int linkId = LinkUtils.matchLink(links, id);
        if (linkId >= 0) {
            String redirect = links.get(linkId).getUrl();
            links.get(linkId).setRedirectCounter(links.get(linkId).getRedirectCounter() + 1);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirect)).build();
        }
        throw new TrackerIdNotFoundException(id);
    }

    @Override
    public LinkDTO getMetrics(int id) throws TrackerIdNotFoundException {
        List<LinkDTO> links = LinkListDTO.linksList;
        int linkId = LinkUtils.matchLink(links, id);
        if (linkId >= 0) return links.get(linkId);
        throw new TrackerIdNotFoundException(id);
    }

    @Override
    public void invalidateLink(int id) {
        List<LinkDTO> links = LinkListDTO.linksList;
        int linkId = LinkUtils.matchLink(links, id);
        if(linkId >= 0) links.get(linkId).setId(-1);
    }
}