package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkInvalidException;
import com.linktracker.demo.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/add")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException {
        return new ResponseEntity<>(linkService.createLink(linkRequestDTO), HttpStatus.CREATED);
    }
}
