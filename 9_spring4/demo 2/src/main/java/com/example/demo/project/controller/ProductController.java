package com.example.demo.project.controller;

import com.example.demo.project.service.IProductService;
import com.example.demo.project.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;


    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id){
        return iProductService.getProductById(id);
    }
}
