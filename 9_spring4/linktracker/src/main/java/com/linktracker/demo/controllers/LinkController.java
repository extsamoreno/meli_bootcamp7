package com.linktracker.demo.controllers;

import com.linktracker.demo.dtos.LinkReportDTO;
import com.linktracker.demo.dtos.LinkRequestDTO;
import com.linktracker.demo.dtos.LinkResponseDTO;
import com.linktracker.demo.exceptions.LinkAlreadyExistException;
import com.linktracker.demo.exceptions.LinkIDNotValidException;
import com.linktracker.demo.exceptions.LinkURLNotValidException;
import com.linktracker.demo.exceptions.ResponseException;
import com.linktracker.demo.services.ILinkService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/add")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkRequestDTO) throws LinkURLNotValidException, LinkAlreadyExistException {
        return new ResponseEntity<>(linkService.createLink(linkRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{linkID}")
    public ResponseEntity<Void> useLink(@PathVariable int linkID) throws LinkIDNotValidException {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkService.getLink(linkID))).build();
    }

    @GetMapping("/reports/{linkID}")
    public ResponseEntity<LinkReportDTO> getReport(@PathVariable int linkID) throws LinkIDNotValidException {
        return new ResponseEntity<>(linkService.getLinkReport(linkID),HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkID) throws ResponseException {
        return new ResponseEntity<>(linkService.invalidateLink(linkID), HttpStatus.OK);
    }
}
