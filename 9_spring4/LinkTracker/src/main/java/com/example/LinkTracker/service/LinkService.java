package com.example.LinkTracker.service;

import com.example.LinkTracker.exception.LinkIdNotFoundException;
import com.example.LinkTracker.exception.LinkInvalidPassException;
import com.example.LinkTracker.models.Link;
import com.example.LinkTracker.repositories.ILinkRepository;
import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;
import com.example.LinkTracker.service.Utils.Mapper.LinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;
    @Override
    public LinkResponseDTO createLink(LinkDTORequest request){
        Integer id = linkRepository.createLink(LinkMapper.mapToLinkResponseDTO(request));
        return new LinkResponseDTO(id.toString());
    }
    @Override
    public String getLink(String id) throws LinkIdNotFoundException {
        Integer idLink = Integer.parseInt(id);
        Link link = linkRepository.getLinks().get(idLink);
        if(link == null){
            throw new LinkIdNotFoundException(idLink);
        }
        link.visita();
        return link.getLink();
    }
    @Override
    public Integer getLinkCantVisitas(String id) throws LinkIdNotFoundException {
        Integer idLink = Integer.parseInt(id);
        Link link = linkRepository.getLinks().get(idLink);
        if(link == null){
            throw new LinkIdNotFoundException(idLink);
        }
        return link.getCant();
    }
    @Override
    public void invalidateLink(String id) throws LinkIdNotFoundException {
        Integer idLink = Integer.parseInt(id);
        Link link = linkRepository.getLinks().remove(idLink);
        if(link == null){
            throw new LinkIdNotFoundException(idLink);
        }
    }

    @Override
    public String getLinkWithPass(String id, String pass) throws LinkIdNotFoundException, LinkInvalidPassException {
        Integer idLink = Integer.parseInt(id);
        Link link = linkRepository.getLinks().get(idLink);
        if(link == null){
            throw new LinkIdNotFoundException(idLink);
        }
        System.out.println(pass);
        System.out.println(link.getPassword());
        if(!link.getPassword().equals(pass)){
            throw new LinkInvalidPassException(idLink);
        }
        link.visita();
        return link.getLink();
    }
}
