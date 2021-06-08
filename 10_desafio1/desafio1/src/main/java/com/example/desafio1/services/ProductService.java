package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.ResponseFollowedPostDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.mappers.PostMapper;
import com.example.desafio1.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserService iUserService;

    @Override
    public String addNewPost(PostDTO postDTO) throws InvalidUserIdException {
        return iProductRepository.addNewPost(postDTO.getUserId(), PostMapper.DTOToPost(postDTO),
                iUserService.getUserById(postDTO.getUserId()));
    }

    @Override
    public ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId) throws InvalidUserIdException {
        return null;
    }
}
