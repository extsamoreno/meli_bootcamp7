package com.example.demo.controller;

import com.example.demo.dto.LinkMetricDTO;
import com.example.demo.dto.LinkRequestDTO;
import com.example.demo.dto.LinkResponseDTO;
import com.example.demo.exceptions.*;
import com.example.demo.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    LinkService linkService;

    @PostMapping("/add")
    public ResponseEntity<LinkResponseDTO> addLink(@RequestBody LinkRequestDTO linkREquestDTO) throws LinkAlreadyExistException, LinkInvalidException, LinkInvalidPasswordException {

        return new ResponseEntity(linkService.addLink(linkREquestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/{password}")
    public RedirectView redirectById(@PathVariable int id, @PathVariable String password) throws LinkIdRequiredException, LinkInvalidException, LinkNotFoundException, LinkInvalidPasswordOrIdException {
        return new RedirectView(linkService.findLinkById(id, password).getAddress());
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkMetricDTO> getMetricsById(@PathVariable int id) throws LinkIdRequiredException, LinkNotFoundException {
        return new ResponseEntity<>(linkService.getMetricsById(id), HttpStatus.OK);
    }

    @GetMapping("invalidate/{id}")
    public ResponseEntity<LinkResponseDTO> invalidateLinkById(@PathVariable int id) throws LinkIdRequiredException, LinkNotFoundException {
        return new ResponseEntity<>(linkService.invalidateLinkById(id), HttpStatus.OK);
    }
    @GetMapping("validate/{id}")
    public ResponseEntity<LinkResponseDTO> validateLinkById(@PathVariable int id) throws LinkIdRequiredException, LinkNotFoundException {
        return new ResponseEntity<>(linkService.validateLinkById(id), HttpStatus.OK);
    }
}
