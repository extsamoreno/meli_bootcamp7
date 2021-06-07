package com.example.linktracker.controllers;

import com.example.linktracker.dtos.LinkResponseDTO;
import com.example.linktracker.dtos.LinkRequestDTO;
import com.example.linktracker.exceptions.AlreadyExistURLException;
import com.example.linktracker.exceptions.InvalidPasswordException;
import com.example.linktracker.exceptions.InvalidURLException;
import com.example.linktracker.services.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URI;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

    @Autowired
    private ITrackerService trackerService;

    @PostMapping("/create")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO linkURL, @RequestParam(required = false, defaultValue = "") String password) throws MalformedURLException, URISyntaxException, InvalidURLException, AlreadyExistURLException {
        return new ResponseEntity<>(trackerService.createLink(linkURL, password), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<LinkResponseDTO> getById(@PathVariable Integer linkId){
        return new ResponseEntity<>(trackerService.getById(linkId),HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<Void> redirectByID(@PathVariable Integer linkId,
                                             @RequestParam(required = false, defaultValue = "") String password) throws InvalidURLException, InvalidPasswordException {
        String strUrl = trackerService.redirectById(linkId,password);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(strUrl)).build();
    }

    @GetMapping("/metric/{linkId}")
    public ResponseEntity<Integer> metricLink(@PathVariable Integer linkId){
        return new ResponseEntity<>(trackerService.getMetric(linkId),HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkResponseDTO> invalidateLink(@PathVariable Integer linkId) throws InvalidURLException {
        return new ResponseEntity<>(trackerService.invalidateLink(linkId),HttpStatus.OK);
    }
}
