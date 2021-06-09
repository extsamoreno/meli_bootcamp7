package com.example.desafio1.services;

import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.dtos.PublishingPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.MeliUser;
import com.example.desafio1.models.Publishing;
import com.example.desafio1.repositories.IProductRepository;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.PublishingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public void processNewPromoPublishing(PublishingPromoDTO pub) {
        iProductRepository.addPublishing(PublishingMapper.toModel(pub));
    }

    @Override
    public List<PublishingDTO> getFollowedPublishings(int userId, String order) throws OrderNotValidException {
        List<Publishing> publishings = new ArrayList<>();
        List<MeliUser> users = iUserRepository.getFollowed(userId,null);
        for (MeliUser user : users) {
            publishings.addAll(iProductRepository.getPublishing(user.getUserId(), LocalDate.now().minusDays(14), LocalDate.now()));
        }
        //We apply order here after retrieving all the publishing from each seller
        if(order != null) {
            switch (order){
                case "order_asc":
                    publishings.sort((a, b) -> a.getDate().compareTo(b.getDate()));
                    break;
                case "order_desc":
                    publishings.sort((a, b) -> b.getDate().compareTo(a.getDate()));
                    break;
                default:
                    throw new OrderNotValidException(order);
            }
        }
        else { //In case no order is received, apply a default order anyway since all publishing's dates will be mixed otherwise
            publishings.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }
        return PublishingMapper.toDTOList(publishings);
    }

    @Override
    public List<PublishingDTO> getPromoPublishings(int userId) {
        return PublishingMapper.toDTOList(iProductRepository.getPromoPublishing(userId));
    }
}
