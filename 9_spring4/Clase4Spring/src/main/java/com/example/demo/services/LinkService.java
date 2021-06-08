package com.example.demo.services;

import com.example.demo.dto.LinkMetricDTO;
import com.example.demo.dto.LinkRequestDTO;
import com.example.demo.dto.LinkResponseDTO;
import com.example.demo.exceptions.*;
import org.springframework.stereotype.Service;

@Service
public interface LinkService {

    LinkResponseDTO addLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkInvalidPasswordException, LinkAlreadyExistException;
    LinkResponseDTO findLinkById(int id, String password) throws LinkIdRequiredException, LinkInvalidException, LinkNotFoundException, LinkInvalidPasswordOrIdException;
    LinkMetricDTO getMetricsById(int id) throws LinkIdRequiredException, LinkNotFoundException;
    LinkResponseDTO invalidateLinkById(int id) throws LinkIdRequiredException, LinkNotFoundException;
    LinkResponseDTO validateLinkById(int id) throws LinkIdRequiredException, LinkNotFoundException;
}
