package com.example.springclase4.project.service;

import com.example.springclase4.project.exception.UrlAlreadyExistException;
import com.example.springclase4.project.exception.UrlNotFoundException;
import com.example.springclase4.project.model.Url;
import com.example.springclase4.project.repository.DTO.UrlSavedDTO;
import com.example.springclase4.project.repository.DTO.UrlMetricsDTO;
import com.example.springclase4.project.repository.DTO.UrlRequestDTO;

import java.util.HashMap;

public interface IUrlService {

   UrlSavedDTO saveUrl(UrlRequestDTO link) throws UrlAlreadyExistException;
   HashMap<Integer, Url> getUrlsList();
   UrlMetricsDTO getRedirected(String linkId) throws  UrlNotFoundException;
   UrlMetricsDTO getUrlMetrics(String linkId) throws UrlNotFoundException;

   Boolean urlExist(UrlRequestDTO link);

   Boolean invalidateUrl(Url url);
   Boolean setValidUrl(Url url);
}
