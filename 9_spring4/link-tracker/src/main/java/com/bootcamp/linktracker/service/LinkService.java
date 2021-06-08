package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.InvalidateLinkResponseDTO;
import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.MetricsDTO;
import com.bootcamp.linktracker.exception.LinkIdNotFoundException;
import com.bootcamp.linktracker.exception.LinkPasswordNotCorrect;
import com.bootcamp.linktracker.mapper.LinkMapper;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws MalformedURLException {

        isValidURI(linkRequestDTO.getUrl());

        Link link = linkRepository.createLink(linkRequestDTO);

        return LinkMapper.toLinkResponseDTO(link);
    }

    @Override
    public String getUrlToRedirect(Integer id, String password) throws LinkIdNotFoundException, LinkPasswordNotCorrect {
        Link link = linkRepository.findById(id);

        if (link == null) {
            throw new LinkIdNotFoundException(id);
        } else if (!link.getPassword().equals(password)) {
            throw new LinkPasswordNotCorrect();
        }

        //Increase the number of redirections
        link.setTotalRedirects(link.getTotalRedirects() + 1);

        return link.getUrl();
    }

    @Override
    public MetricsDTO getLinkMetrics(Integer id) throws LinkIdNotFoundException {
        Link link = linkRepository.findById(id);

        if (link == null) {
            throw new LinkIdNotFoundException(id);
        }

        return LinkMapper.toMetricsDTO(link);
    }

    @Override
    public InvalidateLinkResponseDTO invalidateLink(Integer id) throws LinkIdNotFoundException {
        Link link = linkRepository.deleteLink(id);

        if (link == null) {
            throw new LinkIdNotFoundException(id);
        }
        return LinkMapper.toInvalidateResponseDTO(link);
    }

    //throw an exception if the url is invalid
    private void isValidURI(String urlStr) throws MalformedURLException {
        new URL(urlStr);
    }
}
