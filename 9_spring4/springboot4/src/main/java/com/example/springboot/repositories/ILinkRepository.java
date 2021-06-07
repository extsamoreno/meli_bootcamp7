package com.example.springboot.repositories;

import com.example.springboot.dtos.LinkCountDTO;
import com.example.springboot.dtos.LinkIdDTO;
import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.exceptions.LinkException;
import com.example.springboot.exceptions.URLNotFoundException;
import com.example.springboot.models.Link;

public interface ILinkRepository {
    LinkIdDTO getLinkId(Link link, String password);
    LinkStringDTO getUrlById(Integer linkId, String password) throws LinkException;
    LinkCountDTO getMetricsById(Integer linkId) throws URLNotFoundException;
    LinkIdDTO invalidUrlById(Integer linkId) throws URLNotFoundException;
}
