package com.example.spring4.services;

import com.example.spring4.dtos.LinkCountDTO;
import com.example.spring4.dtos.LinkStringDTO;
import com.example.spring4.dtos.LinkIdDTO;
import com.example.spring4.exceptions.InvalidURLException;
import com.example.spring4.exceptions.LinkException;
import com.example.spring4.exceptions.URLNotFoundException;
import com.example.spring4.exceptions.UnreachableURLException;
import com.example.spring4.mappers.LinkMapper;
import com.example.spring4.repositories.ILinkRepository;
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
