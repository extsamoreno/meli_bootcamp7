package com.example.desafio1.controllers;

import com.example.desafio1.dtos.PublishingDTORequest;
import com.example.desafio1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void postPublishing(@RequestBody PublishingDTORequest publishing){
        iProductService.processNewPublishing(publishing);
    }
}
