package com.meli.linktracker.controller;

import com.meli.linktracker.exception.FormatLinkException;
import com.meli.linktracker.exception.InvalidCredentialsException;
import com.meli.linktracker.exception.InvalidatedLinkException;
import com.meli.linktracker.exception.LinkNotFoundException;
import com.meli.linktracker.service.ILinkService;
import com.meli.linktracker.service.dto.LinkDTORequest;
import com.meli.linktracker.service.dto.LinkDTOResponse;
import com.meli.linktracker.service.dto.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
public class LinkController {
    @Autowired
    ILinkService iLinkService;

    @PostMapping("/create")
    public ResponseEntity<LinkDTOResponse> maskURL(@RequestBody LinkDTORequest link) throws FormatLinkException {
        return new ResponseEntity<>(iLinkService.maskUrl(link),HttpStatus.CREATED);
    }

    @PostMapping("/link/{linkId}")
    public void redirect(@PathVariable int linkId, @RequestBody PasswordDTO password, HttpServletResponse response) throws InvalidCredentialsException, LinkNotFoundException, InvalidatedLinkException {
        iLinkService.redirectUrl(linkId,password.getPassword(), response);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> statictics(@PathVariable int linkId) throws LinkNotFoundException {
        return new ResponseEntity<>(iLinkService.getStatistics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidate(@PathVariable int linkId,@RequestBody PasswordDTO password) throws LinkNotFoundException, InvalidatedLinkException, InvalidCredentialsException {
        return new ResponseEntity<>(iLinkService.invalidate(linkId, password.getPassword()),HttpStatus.ACCEPTED);
    }
}
