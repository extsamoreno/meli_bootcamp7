package com.example.LinkTracker.service;

import com.example.LinkTracker.models.Link;
import com.example.LinkTracker.repositories.ILinkRepository;
import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;
    @Override
    public LinkResponseDTO getLinkID(LinkDTORequest request){
        Map<Integer, Link> linkMap = linkRepository.loadDataBase();

    }
}
