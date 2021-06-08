package com.example.linktracker.controller;

import com.example.linktracker.exception.LinkIncorrectPasswordException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.exception.LinkUnavailableException;
import com.example.linktracker.service.dto.LinkDTO;
import com.example.linktracker.service.dto.ResponseLinkDTO;
import com.example.linktracker.service.iServiceLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    iServiceLink iServiceLink;

    @PostMapping("/tracker")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody LinkDTO link) {
        return new ResponseEntity<>(iServiceLink.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkID}/{password}")
    public ResponseEntity<String> redirectLink(@PathVariable Integer linkID, @PathVariable String password) throws LinkNotFoundException, LinkUnavailableException, LinkIncorrectPasswordException {
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create(iServiceLink.redirectByLinkID(linkID, password))).
                build();
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<ResponseLinkDTO> staticsLink(@PathVariable Integer linkID) throws LinkNotFoundException{
        return new ResponseEntity<>(iServiceLink.getMetricsbyLinkID(linkID), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkID}")
    public ResponseEntity<ResponseLinkDTO> invalidateLink(@PathVariable Integer linkID) throws LinkNotFoundException {
        return new ResponseEntity<>(iServiceLink.invalidateLink(linkID), HttpStatus.OK);
    }
}

