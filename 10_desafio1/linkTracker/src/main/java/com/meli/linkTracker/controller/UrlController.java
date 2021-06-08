package com.meli.linkTracker.controller;

import com.meli.linkTracker.dto.UrlDto;
import com.meli.linkTracker.dto.UrlInputDto;
import com.meli.linkTracker.exception.InvalidFormatUrlException;
import com.meli.linkTracker.exception.InvalidIdUrlException;
import com.meli.linkTracker.exception.UrlException;
import com.meli.linkTracker.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    IUrlService iUrlService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveUrl(@RequestBody UrlInputDto newUrl) throws InvalidFormatUrlException {
        String urlId = iUrlService.addUrl(newUrl);
        return new ResponseEntity<String>(urlId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/link/{linkId}")
    public RedirectView redirect(@PathVariable("linkId") String linkId, @RequestParam(name = "password") String password) throws UrlException {
        return iUrlService.redirect(linkId, password);
    }

    @GetMapping(value = "/metrics/{linkId}")
    public ResponseEntity<UrlDto> metrics(@PathVariable("linkId") String linkId) throws UrlException {
        return new ResponseEntity<UrlDto>(iUrlService.metrics(linkId),HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/invalidate/{linkId}")
    public ResponseEntity<UrlDto> disable(@PathVariable("linkId") String linkId) throws UrlException {
        iUrlService.disable(linkId);
        return new ResponseEntity<UrlDto>(HttpStatus.ACCEPTED);
    }
}
