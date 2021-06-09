package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.models.MeliUser;
import com.example.desafio1.models.Publishing;
import com.example.desafio1.repositories.IProductRepository;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.ProductMapper;
import com.example.desafio1.services.mappers.PublishingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void processNewPublishing(PublishingDTO pub) {
        iProductRepository.addPublishing(PublishingMapper.toModel(pub));
    }

    @Override
    public List<PublishingDTO> getFollowedPublishings(int userId) {
        List<Publishing> publishings = new ArrayList<>();
        List<MeliUser> users = iUserRepository.getFollowed(userId);
        for (MeliUser user : users) {
            publishings.addAll(iProductRepository.getPublishings(user.getUserId(), LocalDate.now().minusDays(14), LocalDate.now()));
        }
        publishings.sort((a,b) -> b.getDate().compareTo(a.getDate()));
        return PublishingMapper.toDTOList(publishings);
    }
}
