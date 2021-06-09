package com.example.desafio1.controllers;

import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.dtos.PublishingPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public String postPublishing(@RequestBody PublishingDTO publishing){
        iProductService.processNewPublishing(publishing);
        return "Your product has been published successfully!";
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<PublishingDTO>> getFollowedPublishings(@PathVariable int userId, @RequestParam(required = false) String order) throws OrderNotValidException {
        return new ResponseEntity<>(iProductService.getFollowedPublishings(userId,order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    @ResponseStatus(HttpStatus.OK)
    public String postPromoPublishing(@RequestBody PublishingPromoDTO publishing){
        iProductService.processNewPublishing(publishing);
        return "Product has been published successfully!";
    }

    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<Integer> getPromoPublishingsCount(@PathVariable int userId){
        return new ResponseEntity<>(iProductService.getPromoPublishings(userId).size(),HttpStatus.OK);
    }

    @GetMapping("/{userId}/list/")
    public ResponseEntity<List<PublishingDTO>> getPromoPublishings(@PathVariable int userId){
        return new ResponseEntity<>(iProductService.getPromoPublishings(userId),HttpStatus.OK);
    }

}