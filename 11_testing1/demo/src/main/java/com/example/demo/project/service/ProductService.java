package com.example.demo.project.service;

import com.example.demo.project.exception.ProductIdNotFoundException;
import com.example.demo.project.models.Product;
import com.example.demo.project.repository.IProductRepository;
import com.example.demo.project.service.dto.ProductDTO;
import com.example.demo.project.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements  IProductService{

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public ProductDTO getProductById(Integer id) throws ProductIdNotFoundException {
        Product product = iProductRepository.getById(id);

        if(product == null){
            throw new ProductIdNotFoundException(id);
        }

        return ProductMapper.toDTO(product);
    }
}
