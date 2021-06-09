package com.example.Challenge.controller;

import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.model.Product;
import com.example.Challenge.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @PostMapping("/newpost")
    public ResponseEntity<String> newPost(@RequestBody Product product){
        iProductService.newPost(product);
        return new ResponseEntity<>("Producto agregado", HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(iProductService.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("followed/{userId}/list")
    public ResponseEntity<ProductResponseDTO> getAllPostById(@PathVariable Integer userId){
        ProductResponseDTO productResponseDTO = iProductService.getPostById(userId);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }
}
