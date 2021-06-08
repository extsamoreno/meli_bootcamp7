package com.api.linktracker.controller;

import com.api.linktracker.dto.LinkRequestDTO;
import com.api.linktracker.dto.LinkResponseDTO;
import com.api.linktracker.dto.MetricsDTO;
import com.api.linktracker.exception.IncorrectIdException;
import com.api.linktracker.exception.IncorrectPasswordException;
import com.api.linktracker.exception.InvalidatedLinkException;
import com.api.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkTrackerController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) {

        return new ResponseEntity<>(linkService.createLink(linkRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public RedirectView redirectLink(@PathVariable int linkId, @RequestParam(required = false) String password) throws IncorrectIdException, IncorrectPasswordException, InvalidatedLinkException {

        if (linkService.linkNotExists(linkId)) {
            throw new IncorrectIdException();
        }

        if (!linkService.isValidLinkId(linkId)) {
            throw new InvalidatedLinkException();
        }

        if (!linkService.isValidPassword(linkId, password)) {
            throw new IncorrectPasswordException();
        }

        return linkService.redirectLink(linkId);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) throws IncorrectIdException {

        if (linkService.linkNotExists(linkId)) {
            throw new IncorrectIdException();
        }

        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }

    @PostMapping("/revalidate/{linkId}")
    public ResponseEntity<String> revalidateLink(@PathVariable int linkId) throws IncorrectIdException {

        if (linkService.linkNotExists(linkId)) {
            throw new IncorrectIdException();
        }

        return new ResponseEntity<>(linkService.revalidateLink(linkId), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsDTO> getRedirectionCounter(@PathVariable int linkId) throws IncorrectIdException {

        if (linkService.linkNotExists(linkId)) {
            throw new IncorrectIdException();
        }

        return new ResponseEntity<>(new MetricsDTO(linkService.getRedirectionCounter(linkId)), HttpStatus.OK);
    }
}

