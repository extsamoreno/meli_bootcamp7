package com.example.springclase3.project.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements IProductRepository{
    @Override
    public Product getById(Integer id) {
        //acá va la lógica que obtiene entidades desde DB
        return new Product(1, "telefono", "asd123", 5);
    }
}
