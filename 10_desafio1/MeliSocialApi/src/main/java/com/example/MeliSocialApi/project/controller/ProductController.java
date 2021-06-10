package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.Utils.Constant;
import com.example.MeliSocialApi.project.exception.ProductNoValidDateException;
import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.service.IProductService;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductPromoCountDTOResponse;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @PostMapping("/newpost")
    public ResponseEntity addProduct(@RequestBody ProductDTO product) throws UserNotFoundException, HttpMessageNotReadableException, ProductNoValidDateException {
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductUserDTOResponse> getProductsByUser(@PathVariable Integer userId, @RequestParam Optional<String> order) throws UserNotFoundException {
        return new ResponseEntity<ProductUserDTOResponse>(productService.getProductFromUser(userId, Constant.weeksOrder, order),HttpStatus.OK);
    }
    @PostMapping("/newpromopost")
    public ResponseEntity addProductPromo(@RequestBody ProductDTO product) throws UserNotFoundException, HttpMessageNotReadableException, ProductNoValidDateException {
        productService.createProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<ProductPromoCountDTOResponse> getCountProductsPromoByUser(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<ProductPromoCountDTOResponse>(productService.getCountProductsPromoByUser(userId),HttpStatus.OK);
    }
    @GetMapping("/{userId}/list")
    public ResponseEntity<ProductUserDTOResponse> getProductsByUser(@PathVariable Integer userId) throws UserNotFoundException {
        return new ResponseEntity<ProductUserDTOResponse>(productService.getProductPromoFromUser(userId),HttpStatus.OK);
    }
}