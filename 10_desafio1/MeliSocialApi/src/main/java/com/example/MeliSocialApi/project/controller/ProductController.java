package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.Utils.Constant;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.service.IProductService;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @PostMapping("/newpost")
    public ResponseEntity addFollower(@RequestBody ProductDTO product) throws UserNotFoundException {
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/followed/{userId}/list")
    public ResponseEntity<ProductUserDTOResponse> addFollower(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<ProductUserDTOResponse>(productService.getProductFromUser(userId, Constant.weeksOrder),HttpStatus.OK);
    }
}