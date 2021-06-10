package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.PostPromoCountDTO;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.exceptions.PostAlreadyExistsException;
import com.example.desafio1.models.MeliUser;
import com.example.desafio1.models.Post;
import com.example.desafio1.repositories.IProductRepository;
import com.example.desafio1.repositories.IUserRepository;
import com.example.desafio1.services.mappers.PostMapper;
import com.example.desafio1.services.utils.PostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void processNewPost(PostDTO post) throws PostAlreadyExistsException {
        //Validate if post already exists (using post Id since we have it here already)
        if (iProductRepository.getPostById(post.getIdPost()) != null)
            throw new PostAlreadyExistsException(post.getIdPost());

        iProductRepository.addPost(PostMapper.toModel(post));
    }

    @Override
    public List<PostDTO> getFollowedPosts(int userId, String order) throws OrderNotValidException {
        List<Post> postList = new ArrayList<>();
        List<MeliUser> userList = iUserRepository.getFollowed(userId, null);
        for (MeliUser user : userList) {
            postList.addAll(iProductRepository.getPosts(user.getUserId(), LocalDate.now().minusDays(14), LocalDate.now()));
        }
        //We then sort by order after retrieving all the posts from each seller.
        //In case order is null we send a default value since posts will be mixed in terms of date otherwise
        PostUtil.sort(postList, order == null ? "date_desc" : order);

        return PostMapper.toDTOList(postList);
    }

    @Override
    public List<PostDTO> getPromoPosts(int userId) {
        return PostMapper.toDTOList(iProductRepository.getPromoPosts(userId));
    }

    @Override
    public PostPromoCountDTO getPromoPostsCount(int userId) {
        PostPromoCountDTO promoCount = new PostPromoCountDTO();
        promoCount.setUserId(userId);
        promoCount.setUserName(iUserRepository.getUserById(userId).getUserName());
        promoCount.setPromoproducts_count(iProductRepository.getPromoPosts(userId).size());

        return promoCount;
    }


}
