package com.example.desafio1.services;

import com.example.desafio1.dtos.FollowersCountDTO;
import com.example.desafio1.dtos.PublishingDTO;
import com.example.desafio1.dtos.PublishingPromoCountDTO;
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
    public List<PublishingDTO> getFollowedPublishing(int userId, String order) throws OrderNotValidException {
        List<Publishing> Publishing = new ArrayList<>();
        List<MeliUser> users = iUserRepository.getFollowed(userId,null);
        for (MeliUser user : users) {
            Publishing.addAll(iProductRepository.getPublishing(user.getUserId(), LocalDate.now().minusDays(14), LocalDate.now()));
        }
        //We apply order here after retrieving all the publishing from each seller
        if(order != null) {
            switch (order){
                case "order_asc":
                    Publishing.sort((a, b) -> a.getDate().compareTo(b.getDate()));
                    break;
                case "order_desc":
                    Publishing.sort((a, b) -> b.getDate().compareTo(a.getDate()));
                    break;
                default:
                    throw new OrderNotValidException(order);
            }
        }
        else { //In case order is null, apply a default order anyway since all publishing's dates will be mixed otherwise
            Publishing.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }
        return PublishingMapper.toDTOList(Publishing);
    }

    @Override
    public List<PublishingDTO> getPromoPublishing(int userId) {
        return PublishingMapper.toDTOList(iProductRepository.getPromoPublishing(userId));
    }

    @Override
    public PublishingPromoCountDTO getPromoPublishingCount(int userId) {
        PublishingPromoCountDTO promoCount = new PublishingPromoCountDTO();
        promoCount.setUserId(userId);
        promoCount.setUserName(iUserRepository.getUserById(userId).getUserName());
        promoCount.setPromoproducts_count(iProductRepository.getPromoPublishing(userId).size());

        return promoCount;
    }
}
