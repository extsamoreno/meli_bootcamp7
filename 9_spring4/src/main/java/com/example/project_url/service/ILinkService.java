package com.example.project_url.service;

import com.example.project_url.exception.*;
import com.example.project_url.service.dto.LinkRequestDTO;
import com.example.project_url.service.dto.LinkResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;

public interface ILinkService {
    LinkResponseDTO create(LinkRequestDTO requestModel) throws LinkExceptionInvalidUrl, LinkExceptionEmptyUrl, LinkExceptionAlreadyExists;

    ResponseEntity<Void> redirect(int linkId, String password) throws URISyntaxException, LinkExceptionInvalidPassword, LinkExceptionNotExists, LinkExceptionInactive;

    LinkResponseDTO metrics(int linkId) throws LinkExceptionNotExists, LinkExceptionInactive;

    void invalidate(int linkId) throws LinkExceptionNotExists, LinkExceptionInactive;
}
