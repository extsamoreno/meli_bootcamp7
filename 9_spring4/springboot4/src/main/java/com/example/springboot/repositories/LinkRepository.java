package com.example.springboot.repositories;

import com.example.springboot.dtos.LinkCountDTO;
import com.example.springboot.dtos.LinkIdDTO;
import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.exceptions.InvalidPasswordException;
import com.example.springboot.exceptions.LinkException;
import com.example.springboot.exceptions.URLNotFoundException;
import com.example.springboot.exceptions.UnreachableURLException;
import com.example.springboot.models.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {
    private HashMap<Integer, Link> linkMap = new HashMap<>();
    private int key = 0;

    @Override
    public LinkIdDTO getLinkId(Link link, String password) {
        LinkIdDTO linkIdDTO = new LinkIdDTO();
        link.setLinkId(key);
        if(!password.equals("")) {
            link.setPassword(password);
        }
        linkMap.put(key, link);
        linkIdDTO.setLinkId(key);
        key++;

        return linkIdDTO;
    }

    @Override
    public LinkStringDTO getUrlById(Integer linkId, String password) throws LinkException {
        Link link = linkMap.get(linkId);
        if(link == null) {
            throw new URLNotFoundException(linkId);
        }
        if(!link.isReachable()) {
            throw new UnreachableURLException(linkId);
        }
        if(!link.getPassword().equals("") && !link.getPassword().equals(password)) {
            throw new InvalidPasswordException(linkId);
        }
        String url = link.getLinkUrl();
        linkMap.get(linkId).countRedirection();
        return new LinkStringDTO(url);
    }

    @Override
    public LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException {
        Link link = linkMap.get(linkId);
        if(link == null) {
            throw new URLNotFoundException(linkId);
        }
        LinkCountDTO linkCountDTO = new LinkCountDTO();
        linkCountDTO.setCount(link.getRedirectedTimes());

        return linkCountDTO;
    }

    @Override
    public LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException {
        Link link = linkMap.get(linkId);
        if(link == null) {
            throw new URLNotFoundException(linkId);
        }
        LinkIdDTO linkIdDTO = new LinkIdDTO();
        linkIdDTO.setLinkId(linkId);
        link.changeStateToInvalid();
        return linkIdDTO;
    }
}
