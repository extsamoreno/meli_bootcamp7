package com.example.linktracker.repositories;

import com.example.linktracker.dtos.*;
import com.example.linktracker.exceptions.AlreadyExistURLException;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;
import com.example.linktracker.models.Link;

public interface ITrackerRepository {
    LinkResponseDTO createLink(LinkRequestDTO link,String password) throws AlreadyExistURLException;
    LinkResponseDTO invalidateLink(Integer id) throws InvalidURLException;
    LinkResponseDTO getById(Integer id);
    Integer getMetric(Integer id);
    String redirectById(Integer linkId, String password) throws InvalidURLException, InvalidPasswordException;
}
