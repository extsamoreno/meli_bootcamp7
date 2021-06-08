package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTORequest;
import com.example.desafio1.models.Publishing;
import com.example.desafio1.repositories.IProductRepository;
import com.example.desafio1.services.mappers.PublishingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Override
    public void processNewPublishing(PublishingDTORequest pub) {
        iProductRepository.addPublishing(PublishingMapper.toModel(pub));
    }
}
