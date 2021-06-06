package com.linktracker.api.controller;

import com.linktracker.api.dto.InvalidateDTO;
import com.linktracker.api.dto.MetricsDTO;
import com.linktracker.api.dto.NewLinkResponseDTO;
import com.linktracker.api.dto.NewLinkResquestDTO;
import com.linktracker.api.exception.*;
import com.linktracker.api.service.LinkTrackerServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;

@RestController
public class LinkTrackerControler {
    @Autowired
    LinkTrackerServiceImple linkTrackerServiceImple;

    @PostMapping("/link")
    public ResponseEntity<NewLinkResponseDTO> newLink (@RequestBody NewLinkResquestDTO newLinkResquestDTO) throws LinkTrackerException {
        return new ResponseEntity<>(linkTrackerServiceImple.addLink(newLinkResquestDTO), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<HttpHeaders> redirectToUrl(@PathVariable int id,
                                                     @RequestParam(value="password", required=false) String password)
            throws URISyntaxException, LinkTrackerException{
        return new ResponseEntity<>(linkTrackerServiceImple.redirectToUrl(id, password),HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<MetricsDTO> metricsById(@PathVariable int id) throws LinkTrackerBadIdException {
        return new ResponseEntity<>(linkTrackerServiceImple.metricsByID(id), HttpStatus.OK);
    }

    @GetMapping("/invalidate/{id}")
    public ResponseEntity<InvalidateDTO> invalidateById(@PathVariable int id) throws LinkTrackerBadIdException {
        return new ResponseEntity<>(linkTrackerServiceImple.invalidateById(id), HttpStatus.OK);
    }
}