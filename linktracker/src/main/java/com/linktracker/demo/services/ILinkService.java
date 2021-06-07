package com.linktracker.demo.services;

import com.linktracker.demo.dtos.LinkMetricDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;

public interface ILinkService {
    LinkResponseDTO createLink(LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException;
    LinkResponseDTO findLinkById(Integer id, String password) throws LinkIdRequiredException, LinkInvalidException, LinkNotFoundException, LinkInvalidPasswordOrIdException;
    LinkMetricDTO getMetricsById(Integer id) throws LinkIdRequiredException, LinkNotFoundException;
    LinkResponseDTO invalidateLinkById(Integer id) throws LinkIdRequiredException, LinkNotFoundException;
}
