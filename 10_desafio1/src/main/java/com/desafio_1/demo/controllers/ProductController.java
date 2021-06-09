package com.desafio_1.demo.controllers;

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
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO product) throws UserIdInvalidException, ProductCategoryInvalidException, ProductPriceInvalidException, UserNotFoundException, UnhandledException, ProductDetailRequiredException, ProductDateInvalidException, ProductIdPostInvalidException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

}
