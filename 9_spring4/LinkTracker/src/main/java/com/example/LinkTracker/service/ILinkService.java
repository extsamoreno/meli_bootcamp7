package com.example.LinkTracker.service;

import com.example.LinkTracker.exception.LinkIdNotFoundException;
import com.example.LinkTracker.exception.LinkInvalidPassException;
import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;

import java.io.IOException;

public interface ILinkService {
    LinkResponseDTO createLink(LinkDTORequest request);
    String getLink(String id)throws LinkIdNotFoundException;
    Integer getLinkCantVisitas(String id) throws LinkIdNotFoundException;
    void invalidateLink(String id) throws LinkIdNotFoundException;
    String getLinkWithPass(String id, String pass) throws LinkIdNotFoundException,LinkInvalidPassException;

}
