package com.springChallenge.api.controller;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.service.contract.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    public void createNewPost(@RequestBody PostDTO postDTO){
        iProductService.createNewPost(postDTO);
    }
}
