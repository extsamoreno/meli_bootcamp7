package com.bootcamp.desafio1.controller;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.dto.response.CountFollowersDTO;
import com.bootcamp.desafio1.dto.response.CountPromoDTO;
import com.bootcamp.desafio1.dto.response.PromoListDTO;
import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.PostNotFoundException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;

import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productServiceImpl;


    @PostMapping("/newpost")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPost(@RequestBody NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException, UserNotFoundException {
        productServiceImpl.insertNewPost(newPostDTO);
    }


    @PostMapping("/newpromopost")
    @ResponseStatus(HttpStatus.OK)
    public void addNewPromoPost(@RequestBody NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException, UserNotFoundException {
        productServiceImpl.insertNewPost(newPostDTO);
    }


    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoDTO> countPromo(@PathVariable int userId) throws UserNotFoundException, PostNotFoundException {
        CountPromoDTO countPromoDTO = productServiceImpl.promoCount(userId);
        return new ResponseEntity(countPromoDTO, HttpStatus.OK);
    }


/*
    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoListDTO> listPromos(@PathVariable int userId) {
        PromoListDTO promoListDTO = productServiceImpl;
        return new ResponseEntity(promoListDTO, HttpStatus.OK);
    }

 */



}
