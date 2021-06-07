package com.example.springboot.services;

import com.example.springboot.dtos.LinkCountDTO;
import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.dtos.LinkIdDTO;
import com.example.springboot.exceptions.InvalidURLException;
import com.example.springboot.exceptions.LinkException;
import com.example.springboot.exceptions.URLNotFoundException;

public interface ILinkService {
    LinkIdDTO getLinkId(LinkStringDTO linkStringDTO, String password) throws InvalidURLException;
    LinkStringDTO getUrlById(Integer linkId, String password) throws LinkException;
    LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException;
    LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException;
}
