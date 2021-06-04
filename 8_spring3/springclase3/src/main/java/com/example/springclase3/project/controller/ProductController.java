package com.example.springclase3.project.controller;

import com.example.springclase3.project.service.IProductService;
import com.example.springclase3.project.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    //@Qualifier("implementacion") por si hay mas de una implementación de la interfaz
    IProductService iProductService;

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Integer id){
        return iProductService.getProductById(id);
    }
}
