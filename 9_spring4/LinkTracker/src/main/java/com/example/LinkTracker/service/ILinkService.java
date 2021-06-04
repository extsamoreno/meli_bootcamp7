package com.example.LinkTracker.service;

import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import com.example.LinkTracker.service.DTOs.Response.LinkResponseDTO;

public interface ILinkService {
    LinkResponseDTO getLinkID(LinkDTORequest request);
}
