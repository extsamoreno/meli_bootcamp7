package com.example.demo.project.controller;

import com.example.demo.project.exception.UrlIdNotFoundException;
import com.example.demo.project.exception.UrlNotValidException;
import com.example.demo.project.service.IUrlService;
import com.example.demo.project.service.dto.UrlDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    IUrlService iUrlService;

    @PostMapping ("/addurl")
    public ResponseEntity<Integer> addUrl(@RequestBody UrlDTO urlDTO)  throws UrlNotValidException {
        return new ResponseEntity<>(iUrlService.addUrlToRepository(urlDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public RedirectView redirectById(@PathVariable Integer id)  throws UrlIdNotFoundException {


        return new RedirectView(iUrlService.getUrlById(id).getUrl());
    }
}
