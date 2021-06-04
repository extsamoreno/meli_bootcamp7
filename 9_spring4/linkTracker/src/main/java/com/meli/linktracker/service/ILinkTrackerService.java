package com.meli.linktracker.service;

import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;

import java.net.URI;

public interface ILinkTrackerService {
    LinkResponseDTO createLink(String url) throws InvalidURLException;

    URI findURIByLinkId(Integer linkId) throws IdNotFoundException;

}
