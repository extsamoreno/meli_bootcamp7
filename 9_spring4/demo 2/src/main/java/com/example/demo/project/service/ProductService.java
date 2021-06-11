package com.example.demo.project.service;

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
    public ProductDTO getProductById(Integer id) {
        return ProductMapper.toDTO(iProductRepository.getById(id));
    }
}
