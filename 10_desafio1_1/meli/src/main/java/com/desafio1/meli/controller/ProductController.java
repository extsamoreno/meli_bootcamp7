package com.desafio1.meli.controller;

import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import com.desafio1.meli.service.productService.IProductservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
public class ProductController{

    @Autowired
    IProductservice iProductservice;


    @PostMapping("/newpost")
    public ResponseEntity<Boolean> setPost(@RequestBody RequestNewProduct requestNewProduct) {

        boolean status = iProductservice.newProduct(requestNewProduct);
        if (status)
            return new ResponseEntity<Boolean>(status, HttpStatus.OK);
        return new ResponseEntity<Boolean>(status, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/followed/{userId}/list/")
    public ResponseEntity<ResponseFollowersListDTO> getFollower(@PathVariable Integer userId) {

        ResponseFollowersListDTO status = iProductservice.listProductFollowerUser(userId);
        return new ResponseEntity<ResponseFollowersListDTO>(status, HttpStatus.OK);
    }
}
