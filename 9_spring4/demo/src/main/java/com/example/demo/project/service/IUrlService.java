package com.example.demo.project.service;


import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.exception.UrlNotValidException;
import com.example.demo.project.service.dto.UrlDTO;

public interface IUrlService {


    Integer addUrlToRepository(UrlDTO urldto) throws UrlNotValidException;
    UrlDTO getUrlById(Integer id)  throws UrlIdNotFoundException;

}
