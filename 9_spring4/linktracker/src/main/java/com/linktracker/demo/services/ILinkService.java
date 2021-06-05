package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkInvalidException;

public interface ILinkService {
    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException;
}
