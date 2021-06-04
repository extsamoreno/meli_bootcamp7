package com.example.linktracker.repositories;

import com.example.linktracker.dtos.request.LinkRequestDTO;
import com.example.linktracker.dtos.response.LinkResponseDTO;
import com.example.linktracker.exceptions.ExistentLinkException;
import com.example.linktracker.exceptions.InvalidLinkException;

public interface LinkRepository {
    LinkResponseDTO agregarLink(LinkRequestDTO linkRequestDTO) throws ExistentLinkException, InvalidLinkException;
}
