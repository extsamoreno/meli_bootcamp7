package com.example.demo.project.service;


import com.example.demo.project.service.dto.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Integer id);
}
