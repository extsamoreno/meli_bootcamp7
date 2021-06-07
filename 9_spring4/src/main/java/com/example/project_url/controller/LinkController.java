package com.example.project_url.controller;

import com.example.project_url.exception.*;
import com.example.project_url.service.ILinkService;
import com.example.project_url.service.dto.LinkRequestDTO;
import com.example.project_url.service.dto.LinkResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> create(@RequestBody LinkRequestDTO linkRequestDTO) throws LinkExceptionAlreadyExists, LinkExceptionInvalidUrl, LinkExceptionEmptyUrl {
        return new ResponseEntity<LinkResponseDTO>(linkService.create(linkRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable int linkId, @RequestParam(required = false) String password) throws URISyntaxException, LinkExceptionInvalidPassword, LinkExceptionNotExists, LinkExceptionInactive {
        //QUe tan correcto es esto? :think:
        return linkService.redirect(linkId, password);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkResponseDTO> metrics(@PathVariable int linkId) throws LinkExceptionNotExists, LinkExceptionInactive {
        return new ResponseEntity<LinkResponseDTO>(linkService.metrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidate(@PathVariable int linkId) throws LinkExceptionNotExists, LinkExceptionInactive {
        linkService.invalidate(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
