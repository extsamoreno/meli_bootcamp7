package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.dtos.PublishingPromoCountDTO;
import com.example.desafio1.dtos.PublishingPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;

import java.util.List;

public interface IProductService {
    void processNewPublishing(PublishingDTO pub);
    void processNewPromoPublishing(PublishingPromoDTO pub);
    List<PublishingDTO> getFollowedPublishing(int userId, String order) throws OrderNotValidException;
    List<PublishingDTO> getPromoPublishing(int userId);
    PublishingPromoCountDTO getPromoPublishingCount(int userId);
}
