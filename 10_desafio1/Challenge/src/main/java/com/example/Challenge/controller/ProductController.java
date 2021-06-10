package com.example.Challenge.controller;

import com.example.Challenge.dto.ProductCountPromoDTO;
import com.example.Challenge.dto.ProductListPromoDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.ProgramException;
import com.example.Challenge.model.Product;
import com.example.Challenge.service.IProductService;
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
    public ResponseEntity<String> newPost(@RequestBody Product product)throws ProgramException {
        iProductService.newPost(product);
        return new ResponseEntity<>("added product", HttpStatus.OK);
    }
    @GetMapping("/list/{idUser}")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable Integer idUser) throws ProgramException {
        return new ResponseEntity<>(iProductService.getAllProduct(idUser), HttpStatus.OK);
    }
    @GetMapping("followed/{userId}/list")
    public ResponseEntity<ProductResponseDTO> getAllPostById(@PathVariable Integer userId, @RequestParam(required = false) String order) throws ProgramException {
        ProductResponseDTO productResponseDTO = iProductService.getPostById(userId, order);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }
    @PostMapping("/newpromopost")
    public ResponseEntity<String> newPromoPost(@RequestBody Product product) throws ProgramException {
        iProductService.newPromoPost(product);
        return new ResponseEntity<>("added product promo", HttpStatus.OK);
    }
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductCountPromoDTO> getCountProductPromo(@PathVariable Integer userId) throws ProgramException {
        ProductCountPromoDTO productCountPromoDTO = iProductService.countProductPromo(userId);
        return new ResponseEntity<>(productCountPromoDTO, HttpStatus.OK);
    }
    @GetMapping("/{userId}/list")
    public ResponseEntity<ProductListPromoDTO> getListProductPromo(@PathVariable Integer userId) throws ProgramException {
        ProductListPromoDTO productListPromoDTO = iProductService.listProductPromo(userId);
        return new ResponseEntity<>(productListPromoDTO, HttpStatus.OK);
    }
}
