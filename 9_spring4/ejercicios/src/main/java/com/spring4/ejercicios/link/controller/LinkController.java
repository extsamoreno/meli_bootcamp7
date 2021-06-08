package com.spring4.ejercicios.link.controller;

import com.spring4.ejercicios.link.exception.ErrorDTO;
import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.exception.InvalidLinkException;
import com.spring4.ejercicios.link.model.Link;
import com.spring4.ejercicios.link.service.ILinkService;
import com.spring4.ejercicios.link.service.dto.request.LinkDTO;
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
    ILinkService linkServiceImpl;

    @PostMapping("/createlink")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkDTO linkDTO){
        return new ResponseEntity(linkServiceImpl.createLink(linkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Object> redirectToExternalUrl(@PathVariable String linkId)
            throws URISyntaxException, InvalidLinkException, IdNotFoundException {
        String sExtLink = linkServiceImpl.getURLbyId(Integer.valueOf(linkId));

        URI extLink = new URI(sExtLink);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(extLink);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

}
