package com.example.socialmeli.service;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.Response.ProductCreateResponseDTO;

import java.util.List;

public interface IProductService {
    ProductCreateResponseDTO addProducts(ProductDTO product);
    List<ProductCreateResponseDTO> addProducts(List<ProductDTO> product);
    List<ProductDTO> getProducts();
}
