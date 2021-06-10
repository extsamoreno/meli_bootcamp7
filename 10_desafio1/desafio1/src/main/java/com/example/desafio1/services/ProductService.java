package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoCountDTO;
import com.example.desafio1.dtos.PostPromoDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.MeliUser;
import com.example.desafio1.models.Post;
import com.example.desafio1.repositories.IProductRepository;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.PostMapper;
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
    public void processNewPost(PostDTO post) {
        iProductRepository.addPost(PostMapper.toModel(post));
    }

    @Override
    public void processNewPromoPost(PostPromoDTO post) {
        iProductRepository.addPost(PostMapper.toModel(post));
    }

    @Override
    public List<PostDTO> getFollowedPosts(int userId, String order) throws OrderNotValidException {
        List<Post> postList = new ArrayList<>();
        List<MeliUser> userList = iUserRepository.getFollowed(userId,null);
        for (MeliUser user : userList) {
            postList.addAll(iProductRepository.getPost(user.getUserId(), LocalDate.now().minusDays(14), LocalDate.now()));
        }
        //We apply order here after retrieving all the posts from each seller
        if(order != null) {
            switch (order){
                case "order_asc":
                    postList.sort((a, b) -> a.getDate().compareTo(b.getDate()));
                    break;
                case "order_desc":
                    postList.sort((a, b) -> b.getDate().compareTo(a.getDate()));
                    break;
                default:
                    throw new OrderNotValidException(order);
            }
        }
        else { //In case order is null, apply a default order anyway since all posts' dates will be mixed otherwise
            postList.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }
        return PostMapper.toDTOList(postList);
    }

    @Override
    public List<PostDTO> getPromoPosts(int userId) {
        return PostMapper.toDTOList(iProductRepository.getPromoPost(userId));
    }

    @Override
    public PostPromoCountDTO getPromoPostsCount(int userId) {
        PostPromoCountDTO promoCount = new PostPromoCountDTO();
        promoCount.setUserId(userId);
        promoCount.setUserName(iUserRepository.getUserById(userId).getUserName());
        promoCount.setPromoproducts_count(iProductRepository.getPromoPost(userId).size());

        return promoCount;
    }
}
