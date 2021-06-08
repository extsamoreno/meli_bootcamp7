package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.Response.ProductCreateResponseDTO;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.service.IProductService;
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
    @PostMapping("/add")
    public ResponseEntity<ProductCreateResponseDTO> addProduct (@RequestBody ProductDTO product){
        return  new ResponseEntity<>(iProductService.addProducts(product),HttpStatus.OK);
    }
    @PostMapping("/add/list")
    public ResponseEntity<List<ProductCreateResponseDTO>> addProductList (@RequestBody List<ProductDTO> products){
        return  new ResponseEntity<>(iProductService.addProducts(products),HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProducts (){
        return  new ResponseEntity<>(iProductService.getProducts(),HttpStatus.OK);
    }
}
