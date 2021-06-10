package com.example.socialmeli.service;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.Response.ProductCreateResponseDTO;

import java.util.List;

public interface IProductService {
    //Add product in list of memory
    ProductCreateResponseDTO addProducts(ProductDTO product);

    //Add product list in list of memory
    List<ProductCreateResponseDTO> addProducts(List<ProductDTO> product);

    // get all products in list of memory
    List<ProductDTO> getProducts();
}
