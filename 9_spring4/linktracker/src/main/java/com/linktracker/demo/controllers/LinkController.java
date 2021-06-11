package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.LinkMetricDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.*;
import com.linktracker.demo.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("link")
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) throws LinkInvalidException, LinkAlreadyExistException, LinkPasswordInvalidException {
        return new ResponseEntity<>(linkService.createLink(linkRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public RedirectView redirectById(@PathVariable Integer id, @RequestParam String password) throws LinkIdRequiredException, LinkInvalidException, LinkNotFoundException, LinkInvalidPasswordOrIdException {
        return new RedirectView(linkService.findLinkById(id, password).getUrl());
    }

    @GetMapping("metrics/{id}")
        public ResponseEntity<LinkMetricDTO> getMetricsById(@PathVariable Integer id) throws LinkIdRequiredException, LinkNotFoundException {
            return new ResponseEntity<>(linkService.getMetricsById(id), HttpStatus.OK);
    }

    @GetMapping("invalidate/{id}")
    public ResponseEntity<LinkResponseDTO> invalidateLinkById(@PathVariable Integer id) throws LinkIdRequiredException, LinkNotFoundException {
        return new ResponseEntity<>(linkService.invalidateLinkById(id), HttpStatus.OK);
    }

}
