package com.meli.linktracker.controller;

import com.meli.linktracker.dto.LinkMetricRequestDTO;
import com.meli.linktracker.dto.LinkRequestDTO;
import com.meli.linktracker.dto.LinkResponseDTO;
import com.meli.linktracker.exception.IdNotFoundException;
import com.meli.linktracker.exception.InvalidURLException;
import com.meli.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("/create")
    public LinkResponseDTO createLink(@RequestBody LinkRequestDTO body) throws InvalidURLException {
        return linkTrackerService.createLink(body.getUrl());
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectByLinkID(@PathVariable Integer linkId) throws IdNotFoundException {
        URI uri = linkTrackerService.findURIByLinkId(linkId);
        return ResponseEntity.status(HttpStatus.FOUND).location(uri).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricRequestDTO> metricsByLinkId(@PathVariable Integer linkId) throws IdNotFoundException {
        LinkMetricRequestDTO metrics = linkTrackerService.findMetricsByLinkId(linkId);
        return new ResponseEntity<>(metrics, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateByLinkId(@PathVariable Integer linkId) throws IdNotFoundException {
        linkTrackerService.invalidateByLinkId(linkId);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Link ID: " + linkId + " invalidated successfully");
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping("/create-multiple")
    public List<LinkResponseDTO> createLinkMultiple(@RequestBody List<LinkRequestDTO> list) {
        return linkTrackerService.createLinkMultiple(list);
    }
}