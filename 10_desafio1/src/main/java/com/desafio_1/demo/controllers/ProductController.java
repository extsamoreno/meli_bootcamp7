package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ProductResponseDTO;
import com.desafio_1.demo.dtos.ProductPromoCountDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.dtos.ProductBaseResponseDTO;
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
    public ResponseEntity addProduct(@RequestBody ProductRequestDTO product) throws UserIdInvalidException, ProductCategoryInvalidException, ProductPriceInvalidException, UserNotFoundException, UnhandledException, ProductDetailRequiredException, ProductDateInvalidException, ProductIdPostInvalidException, ProductDetailIdInvalidException, ProductDetailNameRequiredException, ProductDetailBrandRequiredException, ProductDetailColorRequiredException, ProductDetailTypeRequiredException, ProductDiscountInvalidException, ProductHasPromoNotTrueException {
        productService.addProduct(product);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductResponseDTO> findProductsByFollowedId(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException, UserIdInvalidException, UnhandledException {
        return new ResponseEntity<>(productService.findProductsByFollowedId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductPromoCountDTO> findProductsPromoCountByUserId(@PathVariable int userId) throws UserNotFoundException, UserIdInvalidException, UnhandledException {
        return new ResponseEntity<>(productService.findProductsPromoCountByUserId(userId), HttpStatus.OK);
    }


    @GetMapping("/{userId}/listpromo")
    public ResponseEntity<ProductResponseDTO> findProductsPromoByUserId(@PathVariable int userId) throws UserNotFoundException, UserIdInvalidException, UnhandledException {
        return new ResponseEntity<>(productService.findProductsPromoByUserId(userId), HttpStatus.OK);
    }

}
