package com.example.Challenge.controller;

import com.example.Challenge.dto.ProductCountPromoDTO;
import com.example.Challenge.dto.ProductListPromoDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.UserException;
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
    public ResponseEntity<String> newPost(@RequestBody Product product)throws UserException {
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
    @PostMapping("/newpromopost")
    public ResponseEntity<String> newPromoPost(@RequestBody Product product) throws UserException {
        iProductService.newPromoPost(product);
        return new ResponseEntity<>("Producto promo agregado", HttpStatus.OK);
    }
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductCountPromoDTO> getCountProductPromo(@PathVariable Integer userId) throws UserException{
        ProductCountPromoDTO productCountPromoDTO = iProductService.countProductPromo(userId);
        return new ResponseEntity<>(productCountPromoDTO, HttpStatus.OK);
    }
    @GetMapping("/{userId}/list")
    public ResponseEntity<ProductListPromoDTO> getListProductPromo(@PathVariable Integer userId) throws UserException{
        ProductListPromoDTO productListPromoDTO = iProductService.listProductPromo(userId);
        return new ResponseEntity<>(productListPromoDTO, HttpStatus.OK);
    }
}
