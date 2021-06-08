package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.InvalidateLinkResponseDTO;
import com.bootcamp.linktracker.dto.LinkRequestDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.dto.MetricsDTO;
import com.bootcamp.linktracker.exception.LinkIdNotFoundException;
import com.bootcamp.linktracker.exception.LinkPasswordNotCorrect;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) throws MalformedURLException, URISyntaxException {
        return new ResponseEntity<>(linkService.createLink(linkRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RedirectView redirect(@PathVariable Integer id, @RequestParam String password)
            throws LinkIdNotFoundException, LinkPasswordNotCorrect {
        return new RedirectView(linkService.getUrlToRedirect(id, password));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricsDTO> getLinkMetrics(@PathVariable Integer id) throws LinkIdNotFoundException {
        return new ResponseEntity<>(linkService.getLinkMetrics(id), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<InvalidateLinkResponseDTO> invalidateLink(@PathVariable Integer id) throws LinkIdNotFoundException {
        return new ResponseEntity<>(linkService.invalidateLink(id), HttpStatus.OK);
    }

}
