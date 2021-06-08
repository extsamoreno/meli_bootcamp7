package com.example.demo.project.service;

import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.exception.UrlNotValidException;
import com.example.demo.project.models.Url;
import com.example.demo.project.repository.IUrlRepository;
import com.example.demo.project.service.dto.UrlDTO;
import com.example.demo.project.service.mapper.UrlMapper;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlService implements IUrlService {

    private static final String[] SCHEME = {"http","https"};

    @Autowired
    IUrlRepository iUrlRepository;

    @Override
    public Integer addUrlToRepository(UrlDTO urldto) throws UrlNotValidException{
        UrlValidator urlValidator = new UrlValidator(SCHEME);
        if (urlValidator.isValid(urldto.getUrl())) {
            Url url = UrlMapper.toUrl(urldto);
            return iUrlRepository.addUrl(url);
        } else {
            throw new UrlNotValidException(urldto.getUrl());
        }
    }

    @Override
    public UrlDTO getUrlById(Integer id) throws UrlIdNotFoundException {
        Url url = iUrlRepository.getById(id);
        return UrlMapper.toDTO(url);
    }

}