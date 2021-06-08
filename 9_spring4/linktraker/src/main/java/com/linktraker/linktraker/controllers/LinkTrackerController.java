package com.linktraker.linktraker.controllers;

import com.linktraker.linktraker.exceptions.DisableException;
import com.linktraker.linktraker.exceptions.IncorrectPasswordException;
import com.linktraker.linktraker.exceptions.LinkIdNotFoundException;
import com.linktraker.linktraker.exceptions.LinkNotExistException;
import com.linktraker.linktraker.services.ILinkTrackerService;
import com.linktraker.linktraker.services.dtos.LinkDTO;
import com.linktraker.linktraker.services.dtos.LinkTrackerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/link-tracker")
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService trackerService;

    @PostMapping
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkTrackerDTO linkTrackerDTO) throws LinkNotExistException {
        LinkDTO link = trackerService.createLink(linkTrackerDTO);

        return new ResponseEntity<>(link, HttpStatus.OK);
    }

    @GetMapping("/{idLink}")
    public ResponseEntity<Void> redirectLinkById(@PathVariable int idLink, @RequestParam(value = "password", defaultValue = "") String password)
            throws DisableException, IncorrectPasswordException, LinkIdNotFoundException {
        String strUrl = trackerService.redirectById(idLink, password);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(strUrl)).build();
    }

    @GetMapping("/stats/{idLink}")
    public ResponseEntity<LinkDTO> statsLinksById(@PathVariable int idLink) throws LinkIdNotFoundException {
        LinkDTO linkDTO = trackerService.statsLinksById(idLink);

        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }

    @PostMapping("/{idLink}/disable")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable int idLink) throws LinkIdNotFoundException {
        LinkDTO linkDTO = trackerService.invalidateLink(idLink);

        return new ResponseEntity<>(linkDTO, HttpStatus.OK);
    }
}
