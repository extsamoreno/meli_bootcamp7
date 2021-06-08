package com.example.ejerciciointegradorapi.project.services;

import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerMetricsDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerRequestDTO;
import com.example.ejerciciointegradorapi.project.services.Dto.LinkTrackerResponseDTO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ILinkTrackerService {
    public LinkTrackerResponseDTO createLink(LinkTrackerRequestDTO linkTrackerRequestDTO) throws InvalidUrlException;

    public LinkTrackerResponseDTO redirectUrl(Integer linkId) throws InvalidUrlException;

    public LinkTrackerMetricsDTO getRedirectCounts(Integer linkId) throws InvalidUrlException;

    public void invalidateLink (Integer linkId);
}
