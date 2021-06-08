package com.example.springclase4.project.controller;

import com.example.springclase4.project.exception.UrlAlreadyExistException;
import com.example.springclase4.project.exception.UrlNotFoundException;
import com.example.springclase4.project.repository.DTO.UrlSavedDTO;
import com.example.springclase4.project.repository.DTO.UrlMetricsDTO;
import com.example.springclase4.project.repository.DTO.UrlRequestDTO;
import com.example.springclase4.project.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/link")
public class UrlController {

    @Autowired
    IUrlService iUrlService;

    @PostMapping("/save")
    public ResponseEntity<UrlSavedDTO> saveUrl(@RequestBody UrlRequestDTO link) throws UrlAlreadyExistException{
        return new ResponseEntity<>(iUrlService.saveUrl(link), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<UrlMetricsDTO> getRedirected(@PathVariable String linkId) throws UrlNotFoundException{
        return new ResponseEntity<>(iUrlService.getRedirected(linkId), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<HashMap> getUrls(){
        return new ResponseEntity<>(iUrlService.getUrlsList(), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<UrlMetricsDTO> getMetrics(@PathVariable String linkId) throws UrlNotFoundException
    {
        return new ResponseEntity<>(iUrlService.getUrlMetrics(linkId), HttpStatus.OK);
    }
}
