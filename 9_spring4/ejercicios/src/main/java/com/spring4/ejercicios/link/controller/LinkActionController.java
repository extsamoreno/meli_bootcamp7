package com.spring4.ejercicios.link.controller;

import com.spring4.ejercicios.link.exception.IdNotFoundException;
import com.spring4.ejercicios.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invalidate")
public class LinkActionController {

    @Autowired
    ILinkService linkServiceImpl;

    @PostMapping("/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable Integer linkId) throws IdNotFoundException {
        linkServiceImpl.changeStatusLink(linkId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
