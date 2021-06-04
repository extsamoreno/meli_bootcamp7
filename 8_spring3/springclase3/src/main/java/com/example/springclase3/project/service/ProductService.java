package com.example.springclase3.project.service;

import com.example.springclase3.project.repository.IProductRepository;
import com.example.springclase3.project.service.dto.ProductDTO;
import com.example.springclase3.project.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;


    @Override
    public ProductDTO getProductById(Integer id){

        return ProductMapper.toDTO(iProductRepository.getById(id));

    }

}

