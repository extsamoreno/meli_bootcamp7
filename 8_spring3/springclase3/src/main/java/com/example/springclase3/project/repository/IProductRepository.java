package com.example.springclase3.project.repository;

import com.example.springclase3.project.service.dto.ProductDTO;

public interface IProductRepository {

    Product getById(Integer id);
}
