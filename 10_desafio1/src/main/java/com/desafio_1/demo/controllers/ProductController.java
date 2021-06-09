package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ProductFollowedDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.exceptions.*;
import com.desafio_1.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO product) throws UserIdInvalidException, ProductCategoryInvalidException, ProductPriceInvalidException, UserNotFoundException, UnhandledException, ProductDetailRequiredException, ProductDateInvalidException, ProductIdPostInvalidException, ProductDetailIdInvalidException, ProductDetailNameRequiredException, ProductDetailBrandRequiredException, ProductDetailColorRequiredException, ProductDetailTypeRequiredException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductFollowedDTO> findProductsByFollowedId(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException, UserIdInvalidException, UnhandledException {
        return new ResponseEntity<>(productService.findProductsByFollowedId(userId, order), HttpStatus.OK);
    }

}
