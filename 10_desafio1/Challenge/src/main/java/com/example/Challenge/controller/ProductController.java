package com.example.Challenge.controller;

import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.UserException;
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
    public ResponseEntity<String> newPost(@RequestBody Product product) throws ProductException{
        iProductService.newPost(product);
        return new ResponseEntity<>("Producto agregado", HttpStatus.OK);
    }
    @GetMapping("/list/{idUser}")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable Integer idUser) throws UserException {
        return new ResponseEntity<>(iProductService.getAllProduct(idUser), HttpStatus.OK);
    }
    @GetMapping("followed/{userId}/list")
    public ResponseEntity<ProductResponseDTO> getAllPostById(@PathVariable Integer userId, @RequestParam(required = false) String order) throws UserException{
        ProductResponseDTO productResponseDTO = iProductService.getPostById(userId, order);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }
}
