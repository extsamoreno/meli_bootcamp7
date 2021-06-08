package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTORequest;

public interface IProductService {
    void processNewPublishing(PublishingDTORequest pub);
}
