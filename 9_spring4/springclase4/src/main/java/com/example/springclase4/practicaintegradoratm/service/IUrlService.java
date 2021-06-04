package com.example.springclase4.practicaintegradoratm.service;

import com.example.springclase4.practicaintegradoratm.model.Url;
import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlDTO;
import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlRequestDTO;

public interface IUrlService {

   String saveUrl(UrlRequestDTO link);
   UrlDTO getRedirected(String linkId);
   Boolean invalidateUrl(Url url);
   Boolean setValidUrl(Url url);
}
