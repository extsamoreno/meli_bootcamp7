package com.example.springclase4.practicaintegradoratm.controller;

import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlDTO;
import com.example.springclase4.practicaintegradoratm.repository.DTO.UrlRequestDTO;
import com.example.springclase4.practicaintegradoratm.service.IUrlService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class UrlsController {

    @Autowired
    IUrlService iUrlService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUrl(@RequestBody UrlRequestDTO link){
        return new ResponseEntity<>(iUrlService.saveUrl(link), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<UrlDTO> getRedirected(@PathVariable String linkId){
        return new ResponseEntity<>(iUrlService.getRedirected(linkId), HttpStatus.OK);
    }

}
