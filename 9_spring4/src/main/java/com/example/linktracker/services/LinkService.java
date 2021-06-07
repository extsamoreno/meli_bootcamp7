package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.EstadisticaResponseDTO;
import com.example.linktracker.dtos.response.InvalidateLinkResponseDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.LinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;
import org.springframework.stereotype.Service;

@Service
public interface LinkService {
    LinkResponseDTO crearLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException;
    EstadisticaResponseDTO obtenerEstadisticas(int idLink) throws UnexistentLinkException;
    InvalidateLinkResponseDTO invalidarLink(int idLink) throws UnexistentLinkException;
    //LinkDTO redireccionarLink(int linkId) throws LinkException;
}
