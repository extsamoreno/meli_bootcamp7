package com.example.demo.project.services;


import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.dtos.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Integer id)  throws ProductIdNotFoundException;

    boolean createProduct(ProductDTO product);

    Integer getExpiration(int day, int month, int year);
}
