package com.example.socialmeli.service;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.Response.ProductCreateResponseDTO;
import com.example.socialmeli.mapper.ProductMapper;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    ProductMapper productMapper;
    IProductRepository iProductRepository;

    public ProductService(ProductMapper productMapper, IProductRepository iProductRepository) {
        this.productMapper = productMapper;
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ProductCreateResponseDTO addProducts(ProductDTO product) {
        return new ProductCreateResponseDTO(productMapper.toProductDTO(iProductRepository.addProduct(productMapper.toProduct(product))));
    }

    @Override
    public List<ProductCreateResponseDTO> addProducts(List<ProductDTO> product) {
        List<ProductCreateResponseDTO> response = new ArrayList<>();
        for (ProductDTO obj : product) {
            response.add(addProducts(obj));
        }
        return response;
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<ProductDTO> response = new ArrayList<>();
        for (Product obj : iProductRepository.getProducts()) {
            response.add(productMapper.toProductDTO(obj));
        }
        return response;
    }
}
