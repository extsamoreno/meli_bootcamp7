package com.meli.linktracker.controller;

import com.meli.linktracker.dto.LinkRequestDTO;
import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;
import com.meli.linktracker.service.ILinkTrackerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("/create")
    public LinkResponseDTO createLink(@RequestBody LinkRequestDTO body) throws InvalidURLException {
        return linkTrackerService.createLink(body.getUrl());
    }


    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectByLinkID(@PathVariable Integer linkId) throws IdNotFoundException {
        URI uri = linkTrackerService.findURIByLinkId(linkId);
        return ResponseEntity.status(HttpStatus.FOUND).location(uri).build();

    }
}
