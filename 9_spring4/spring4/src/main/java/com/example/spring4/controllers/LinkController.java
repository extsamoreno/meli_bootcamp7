package com.example.spring4.controllers;

import com.example.spring4.dtos.LinkCountDTO;
import com.example.spring4.dtos.LinkStringDTO;
import com.example.spring4.dtos.LinkIdDTO;
import com.example.spring4.exceptions.InvalidURLException;
import com.example.spring4.exceptions.LinkException;
import com.example.spring4.exceptions.URLNotFoundException;
import com.example.spring4.exceptions.UnreachableURLException;
import com.example.spring4.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/getId")
    public ResponseEntity<LinkIdDTO> getLinkId(@RequestBody LinkStringDTO linkStringDTO) throws InvalidURLException {
        return new ResponseEntity(iLinkService.getLinkId(linkStringDTO), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getUrlById(@PathVariable Integer linkId) throws LinkException {
        return new RedirectView(iLinkService.getUrlById(linkId).getLinkUrl());
    }

    @GetMapping("/metrics/link/{linkId}")
    public ResponseEntity<LinkCountDTO> getMetricsById(@PathVariable Integer linkId) throws URLNotFoundException {
        return new ResponseEntity(iLinkService.getMetricsById(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/link/{linkId}")
    public ResponseEntity<LinkIdDTO> invalidUrlById(@PathVariable Integer linkId) throws URLNotFoundException {
        return new ResponseEntity(iLinkService.invalidUrlById(linkId), HttpStatus.OK);
    }

}
