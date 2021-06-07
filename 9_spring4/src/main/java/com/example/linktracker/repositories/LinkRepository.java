package com.example.linktracker.repositories;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.InvalidateLinkResponseDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;
import com.example.linktracker.exceptions.UnexistentLinkException;

public interface LinkRepository {
    LinkResponseDTO agregarLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException;
    LinkDTO buscarLink(int idLink) throws UnexistentLinkException;
    InvalidateLinkResponseDTO invalidarLink (int idLink) throws UnexistentLinkException;
}
