package com.example.demo.services;

import com.example.demo.dto.LinkMetricDTO;
import com.example.demo.dto.LinkRequestDTO;
import com.example.demo.exceptions.*;
import com.example.demo.models.Link;
import com.example.demo.dto.LinkResponseDTO;
import com.example.demo.repository.LinkRepositoryImple;
import com.example.demo.services.mapper.LinkMapper;
import com.example.demo.services.mapper.MetricMapper;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImple implements LinkService{

    @Autowired
    LinkRepositoryImple linkRepositoryImple;


    @Override
    public LinkResponseDTO addLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkInvalidPasswordException, LinkAlreadyExistException {
        LinkResponseDTO linkResponse = null;

        UrlValidator defaultValidator = new UrlValidator();
        boolean isUrlValid = defaultValidator.isValid(linkRequestDTO.getAddress());

        Link linkExist = linkRepositoryImple.findLinkByAddress(linkRequestDTO.getAddress());

        if(!validatePassword(linkRequestDTO.getPassword())){
            throw new LinkInvalidPasswordException();
        }

        if(!isUrlValid){
            throw new LinkInvalidException(linkRequestDTO.getAddress());
        }

        if(linkExist != null){
            throw new LinkAlreadyExistException(linkRequestDTO.getAddress());
        }

        Link link = LinkMapper.toModel(linkRequestDTO);
        linkResponse = LinkMapper.toDTO(linkRepositoryImple.addLink(link));

        return linkResponse;
    }

    @Override
    public LinkResponseDTO findLinkById(int id, String password) throws LinkIdRequiredException, LinkInvalidException,LinkNotFoundException, LinkInvalidPasswordOrIdException {
        LinkResponseDTO linkResponse = null;

        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        Link link = linkRepositoryImple.findLinkById(id, password);

        if(!link.isValid()){
            throw new LinkInvalidException(link.getAddress());
        }

        linkResponse = LinkMapper.toDTO(link);
        linkRepositoryImple.addLinkCounter(id);
        return linkResponse;
    }



    @Override
    public LinkMetricDTO getMetricsById(int id) throws LinkIdRequiredException, LinkNotFoundException {
        LinkMetricDTO metricResponse = null;

        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        metricResponse = MetricMapper.toDTO(linkRepositoryImple.getLinkCounter(id));

        return metricResponse;
    }

    @Override
    public LinkResponseDTO invalidateLinkById(int id) throws LinkIdRequiredException, LinkNotFoundException {
        LinkResponseDTO linkResponse = null;
        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        linkResponse = LinkMapper.toDTO(linkRepositoryImple.invalidateLinkByAddress(id));
        return linkResponse;
    }

    @Override
    public LinkResponseDTO validateLinkById(int id) throws LinkIdRequiredException, LinkNotFoundException {
        LinkResponseDTO linkResponse = null;
        if(id <= 0){
            throw new LinkIdRequiredException();
        }

        linkResponse = LinkMapper.toDTO(linkRepositoryImple.validateLinkByAddress(id));
        return linkResponse;
    }

        private boolean validatePassword(String password){
        final String regex = "^.*(?=.*[0-9])(?=.*[a-z]).*$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
