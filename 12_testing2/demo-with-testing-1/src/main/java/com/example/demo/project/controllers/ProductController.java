package com.example.demo.project.controllers;

import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.services.IProductService;
import com.example.demo.project.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;


    public ProductController(IProductService iProductService){
        this.iProductService = iProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Integer id)  throws ProductIdNotFoundException {
        return new ResponseEntity<>(iProductService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(iProductService.createProduct(product), HttpStatus.OK);
    }

    @GetMapping("/{day}/{month}/{year}")
    public Integer getExpiration(@PathVariable("day") Integer day,@PathVariable("month") Integer month,@PathVariable("year") Integer year){
        return iProductService.getExpiration(day,month,year);
    }
}
