package com.ejercitacion.ejercitacion.controller;

import com.ejercitacion.ejercitacion.dto.LinkIdResponse;
import com.ejercitacion.ejercitacion.dto.LinkRedirectionStadisticsResponse;
import com.ejercitacion.ejercitacion.dto.StoreLinkRequest;
import com.ejercitacion.ejercitacion.exception.InvalidLinkPasswordException;
import com.ejercitacion.ejercitacion.exception.LinkException;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;
import com.ejercitacion.ejercitacion.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class LinkController {


    @Autowired
    private LinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<LinkIdResponse> storeNewLink(@RequestBody StoreLinkRequest request) throws LinkException {
        return ResponseEntity.ok(linkService.storeNewLink(request));
    }

    @GetMapping("/links/redirection/{id}")
    public ResponseEntity<Void> redirect(@PathVariable  Integer id, @RequestParam(required = false) String password) throws LinkIdNotFoundException, InvalidLinkPasswordException, LinkException {
//        return new ModelAndView("redirect" + linkService.getRequestedLink(id, password));
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkService.getRequestedLinkForRedirection(id, password))).build();
    }

    @GetMapping("/links/metrics/{id}")
    public ResponseEntity<LinkRedirectionStadisticsResponse> getRedirectionStadistics(@PathVariable Integer id) throws LinkIdNotFoundException {
        return ResponseEntity.ok(linkService.getRedirectionsStadistics(id));
    }

    @PatchMapping("/links/{id}/invalidation")
    public ResponseEntity invalidateLink(@PathVariable Integer id) throws LinkIdNotFoundException {
        linkService.invalidateLink(id);
        return ResponseEntity.noContent().build();
    }
}
