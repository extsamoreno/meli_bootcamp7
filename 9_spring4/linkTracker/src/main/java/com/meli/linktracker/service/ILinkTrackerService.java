package com.meli.linktracker.service;

import com.meli.linktracker.dto.LinkMetricRequestDTO;
import com.meli.linktracker.dto.LinkRequestDTO;
import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;

import java.net.URI;
import java.util.List;

public interface ILinkTrackerService {
    LinkResponseDTO createLink(String url) throws InvalidURLException;

    URI findURIByLinkId(Integer linkId) throws IdNotFoundException;

    LinkMetricRequestDTO findMetricsByLinkId(Integer linkId) throws IdNotFoundException;

    void invalidateByLinkId(Integer linkId) throws IdNotFoundException;

    List<LinkResponseDTO> createLinkMultiple(List<LinkRequestDTO> list);

}
