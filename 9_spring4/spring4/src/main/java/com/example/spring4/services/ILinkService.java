package com.example.spring4.services;

import com.example.spring4.dtos.LinkCountDTO;
import com.example.spring4.dtos.LinkStringDTO;
import com.example.spring4.dtos.LinkIdDTO;
import com.example.spring4.exceptions.InvalidURLException;
import com.example.spring4.exceptions.LinkException;
import com.example.spring4.exceptions.URLNotFoundException;

public interface ILinkService {
    LinkIdDTO getLinkId(LinkStringDTO linkStringDTO) throws InvalidURLException;
    LinkStringDTO getUrlById(Integer linkId) throws LinkException;
    LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException;
    LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException;
}
