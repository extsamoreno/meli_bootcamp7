package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.InvalidateLinkResponseDTO;
import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.MetricsDTO;
import com.bootcamp.linktracker.exception.LinkIdNotFoundException;
import com.bootcamp.linktracker.exception.LinkPasswordNotCorrect;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ILinkService {
    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws URISyntaxException, MalformedURLException;

    String getUrlToRedirect(Integer id, String password) throws LinkIdNotFoundException, LinkPasswordNotCorrect;

    MetricsDTO getLinkMetrics(Integer id) throws LinkIdNotFoundException;

    InvalidateLinkResponseDTO invalidateLink(Integer id) throws LinkIdNotFoundException;
}
