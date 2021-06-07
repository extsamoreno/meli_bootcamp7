package com.example.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.example.springboot.dtos.LinkCountDTO;
import com.example.springboot.dtos.LinkStringDTO;
import com.example.springboot.dtos.LinkIdDTO;
import com.example.springboot.exceptions.InvalidURLException;
import com.example.springboot.exceptions.LinkException;
import com.example.springboot.exceptions.URLNotFoundException;
import com.example.springboot.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;


// Controlador que redirecciona a un conjunto de links
@RestController
@RequestMapping("/links")
public class LinkController {

    //Inyectar dependencias
    @Autowired
    ILinkService iLinkService;

    @PostMapping("/getId")
    public ResponseEntity<LinkIdDTO> getLinkId(
            @RequestBody LinkStringDTO linkStringDTO,
            @RequestParam(required = false, defaultValue = "") String password) throws InvalidURLException {
        return new ResponseEntity(iLinkService.getLinkId(linkStringDTO, password), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getUrlById(@PathVariable Integer linkId,
                                   @RequestParam(required = false, defaultValue = "") String password
                                    ) throws LinkException {
        return new RedirectView(iLinkService.getUrlById(linkId, password).getLinkUrl());
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
