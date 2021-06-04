package com.example.LinkTracker.controller;

import com.example.LinkTracker.service.DTOs.Request.LinkDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/createlink")
    public ResponseEntity<?> createLink(@RequestBody LinkDTORequest linkRequest){

    }
}
