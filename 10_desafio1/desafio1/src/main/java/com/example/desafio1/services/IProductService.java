package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTO;

import java.util.List;

public interface IProductService {
    void processNewPublishing(PublishingDTO pub);
    List<PublishingDTO> getFollowedPublishings(int userId);
}
