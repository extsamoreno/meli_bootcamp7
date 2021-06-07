package com.meli.linktracker.controller;

import com.meli.linktracker.service.ILinkService;
import com.meli.linktracker.service.dto.LinkDTO;
import com.meli.linktracker.service.dto.LinkResponseDto;
import com.meli.linktracker.service.dto.MetricsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/tracker")
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkDTO link) {
        return new ResponseEntity<LinkResponseDto>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<Object> redirectToExternalUrl(@PathVariable Integer linkId) throws URISyntaxException {
        LinkDTO link = linkService.getUrlById(linkId);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (link != null) {
            URI linkRedirect = new URI(link.getUrl());
            httpHeaders.setLocation(linkRedirect);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        }
        return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsDTO> getMetricsByLinkId(@PathVariable int linkId) {
        return new ResponseEntity<MetricsDTO>(linkService.getMetricsByLinkId(linkId), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkResponseDto> invalidateLinkById(@PathVariable int linkId) {
        return new ResponseEntity<LinkResponseDto>(linkService.invalidateLinkById(linkId), HttpStatus.OK);
    }

}
