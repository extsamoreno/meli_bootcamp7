package com.springChallenge.api.service.implementation;

import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.contract.IProductRepository;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.service.contract.IProductService;
import com.springChallenge.api.service.mapper.product.PostMapper;
import com.springChallenge.api.service.mapper.product.PostsListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void createNewPost(PostDTO postDTO) throws UserNotFoundException {
        validatePost(postDTO);
        var post = PostMapper.toEntity(postDTO);
        var user = iUserRepository.getByUserId(post.getUserId());
        //TODO:add post existing validation
        user.addPost(post);
        iUserRepository.save(user);
    }

    @Override
    public PostsListDTO getPostsByUserId(Integer userId) throws UserNotFoundException {
        var user = iUserRepository.getByUserId(userId);
        return PostsListMapper.toDTO(user);
    }

    private void validatePost(PostDTO postDTO) {
        //TODO:add date comparator
        //if (postDTO.getDate().after())
    }
}
