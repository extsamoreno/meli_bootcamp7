package com.linkTracker;

import com.exceptions.HandlerException;
import com.exceptions.InvalidUrlException;
import com.linkTracker.repository.iLinkTrackerRepository;
import com.models.LinkDTO;
import com.models.UrlDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkTrackerController {

    @Autowired
    iLinkTrackerService service;

    @PostMapping("/create")
    public ResponseEntity<UrlDTO> createLink(@RequestBody String url) throws InvalidUrlException {
        return (new ResponseEntity<>(service.createLink(url), HttpStatus.OK));
    }

    @PostMapping("/create")
    public ResponseEntity<UrlDTO> createLinkPassword(@RequestBody String url, @RequestParam String password) {
        return (new ResponseEntity<>(service.createLink(url, password), HttpStatus.OK));
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<LinkDTO> redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = service.redirect(linkId);
        if (link != null)
            response.sendRedirect(link.getUrl());
        else
            response.sendError(404);
        return (new ResponseEntity<>(link, HttpStatus.OK));
    }

    @GetMapping("/redirect/{linkId}")
    public ResponseEntity<LinkDTO> redirectPassword(@PathVariable Integer linkId, @RequestParam String password, HttpServletResponse response) throws IOException {
        LinkDTO link = service.redirect(linkId, password);
        if (link != null)
            response.sendRedirect(link.getUrl());
        else
            response.sendError(404);
        return (new ResponseEntity<>(link, HttpStatus.OK));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> calculateRedirectionMetrics(@PathVariable Integer linkId) {
        return new ResponseEntity<>(service.calculateRedirectionMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkDTO> invalidateLink(@PathVariable Integer linkId){
        return new ResponseEntity<>(service.invalidateLink(linkId), HttpStatus.OK);
    }
}