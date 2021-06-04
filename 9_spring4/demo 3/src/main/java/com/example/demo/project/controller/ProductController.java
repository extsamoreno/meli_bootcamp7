package com.example.demo.project.controller;

import com.example.demo.project.exception.ProductIdNotFoundException;
import com.example.demo.project.service.IProductService;
import com.example.demo.project.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;


    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Integer id)  throws ProductIdNotFoundException {
        return new ResponseEntity<>(iProductService.getProductById(id), HttpStatus.OK);
    }
}
