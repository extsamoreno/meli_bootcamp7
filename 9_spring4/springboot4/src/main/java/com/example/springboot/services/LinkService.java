package com.example.springboot.services;

import com.example.springboot.dtos.LinkCountDTO;
import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.dtos.LinkIdDTO;
import com.example.springboot.exceptions.InvalidURLException;
import com.example.springboot.exceptions.LinkException;
import com.example.springboot.exceptions.URLNotFoundException;
import com.example.springboot.mappers.LinkMapper;
import com.example.springboot.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class LinkService implements ILinkService {

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkIdDTO getLinkId(LinkStringDTO linkStringDTO, String password) throws InvalidURLException {
        try {
            new URL(linkStringDTO.getLinkUrl()).toURI();
        } catch (Exception e) {
            throw new InvalidURLException(linkStringDTO.getLinkUrl());
        }
        return iLinkRepository.getLinkId(LinkMapper.toObject(linkStringDTO), password);
    }

    @Override
    public LinkStringDTO getUrlById(Integer linkId, String password) throws LinkException {
        return iLinkRepository.getUrlById(linkId, password);
    }

    @Override
    public LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException {
        return iLinkRepository.getMetricsById(linkId);
    }

    @Override
    public LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException {
        return iLinkRepository.invalidUrlById(linkId);
    }
}
