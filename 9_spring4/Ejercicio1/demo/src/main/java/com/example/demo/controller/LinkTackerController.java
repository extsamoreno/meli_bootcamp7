package com.example.demo.controller;

import com.example.demo.controller.exception.ExistLinkException;
import com.example.demo.controller.exception.NotFoundLinkException;
import com.example.demo.controller.exception.NotFoundLinkStatisticException;
import com.example.demo.controller.exception.NotValidURLException;
import com.example.demo.services.DTO.LinkDTO;
import com.example.demo.services.ILinkTackerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class LinkTackerController {

    @Autowired
    ILinkTackerServices linkTackerServices;

    @PostMapping("/newLink")
    public ResponseEntity<LinkDTO> newLink(@RequestBody LinkDTO linkDTO) throws NotValidURLException, ExistLinkException {
        return new ResponseEntity<>(linkTackerServices.newLink(linkDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/link/{linkId}",method = RequestMethod.GET)
    public ResponseEntity<HttpHeaders> localRedirect(@PathVariable String linkId) throws NotFoundLinkException, URISyntaxException, NotValidURLException {
        return new ResponseEntity<>(linkTackerServices.localRedirect(linkId),HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> metrics(@PathVariable String linkID) throws NotFoundLinkStatisticException {
        return new ResponseEntity<>(linkTackerServices.metrics(linkID),HttpStatus.OK);
    }
}
