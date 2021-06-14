package com.example.demo.service;


import com.example.demo.Exceptions.*;
import com.example.demo.repository.entities.Url;
import com.example.demo.service.dto.UrlDTO;
import org.springframework.http.HttpStatus;

public interface IMaskUrlService {

    UrlDTO getLink(Url url) throws UrlNotValidException;

    String getUrlNameByLink(Integer i, String pass) throws LinkNotFoundException, InvalidPassException, BloquedLinkException;

    boolean isValid(Url url);

    UrlDTO getLinkMetrics(Integer linkId) throws LinkNotFoundException;

    boolean setInvalidLink(Integer linkId) throws DisableException;
}
