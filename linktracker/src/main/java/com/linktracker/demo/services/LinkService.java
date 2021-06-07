package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkMetricDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;
import com.linktracker.demo.models.Link;
import com.linktracker.demo.repositories.ILinkRepository;
import com.linktracker.demo.services.mappers.LinkMapper;
import com.linktracker.demo.services.mappers.MetricMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.UrlValidator;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException {
        LinkResponseDTO linkResponse = null;

        UrlValidator defaultValidator = new UrlValidator();
        boolean isUrlValid = defaultValidator.isValid(linkRequestDTO.getUrl());

        Link linkExist = linkRepository.findLinkByUrl(linkRequestDTO.getUrl());

        if(!isUrlValid){
            throw new LinkInvalidException(linkRequestDTO.getUrl());
        }
        else if(linkExist != null){
            throw new LinkAlreadyExistException(linkRequestDTO.getUrl());
        }

        Link link = LinkMapper.toModel(linkRequestDTO);
        linkResponse = LinkMapper.toDTO(linkRepository.addLink(link));

        return linkResponse;
    }

    @Override
    public LinkResponseDTO findLinkById(Integer id, String password) throws LinkIdRequiredException, LinkInvalidException,LinkNotFoundException, LinkInvalidPasswordOrIdException {
        LinkResponseDTO linkResponse = null;

        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        Link link = linkRepository.findLinkById(id, password);

        if(!link.isValid()){
            throw new LinkInvalidException(link.getUrl());
        }

        linkResponse = LinkMapper.toDTO(link);
        linkRepository.addLinkCounter(id);
        return linkResponse;
    }

    @Override
    public LinkMetricDTO getMetricsById(Integer id) throws LinkIdRequiredException, LinkNotFoundException {
        LinkMetricDTO metricResponse = null;

        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        metricResponse = MetricMapper.toDTO(linkRepository.getLinkCounter(id));

        return metricResponse;
    }

    @Override
    public LinkResponseDTO invalidateLinkById(Integer id) throws LinkIdRequiredException, LinkNotFoundException {
        LinkResponseDTO linkResponse = null;
        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        linkResponse = LinkMapper.toDTO(linkRepository.invalidateLinkByUrl(id));
        return linkResponse;
    }

}
