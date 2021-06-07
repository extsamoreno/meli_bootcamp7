package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkResponseDTO;
import com.example.linktracker.dtos.LinkRequestDTO;
import com.example.linktracker.exceptions.AlreadyExistURLException;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ITrackerService {
    LinkResponseDTO createLink(LinkRequestDTO linkURL, String password) throws MalformedURLException, URISyntaxException, InvalidURLException, AlreadyExistURLException;
    LinkResponseDTO getById(Integer linkId);
    Integer getMetric(Integer linkId);
    LinkResponseDTO invalidateLink(Integer linkId) throws InvalidURLException;
    String redirectById(Integer linkId, String password) throws InvalidURLException, InvalidPasswordException;
}
