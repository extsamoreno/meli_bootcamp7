package com.example.spring4.repositories;

import com.example.spring4.dtos.LinkCountDTO;
import com.example.spring4.dtos.LinkIdDTO;
import com.example.spring4.dtos.LinkStringDTO;
import com.example.spring4.exceptions.LinkException;
import com.example.spring4.exceptions.URLNotFoundException;
import com.example.spring4.exceptions.UnreachableURLException;
import com.example.spring4.models.Link;

public interface ILinkRepository {
    LinkIdDTO getLinkId(Link link, String password);
    LinkStringDTO getUrlById(Integer linkId, String password) throws LinkException;
    LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException;
    LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException;
}
