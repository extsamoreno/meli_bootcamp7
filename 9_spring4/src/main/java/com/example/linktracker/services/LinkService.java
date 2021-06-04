package com.example.linktracker.services;

import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import org.springframework.stereotype.Service;

@Service
public interface LinkService {
    LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException;
    //EstadisticaResponseDTO obtenerEstadisticas(String idLink);
    //UrlResponseDTO invalidarLink(String idLink);

}
