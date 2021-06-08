package com.meli.spring_challenge.service.product;

import com.meli.spring_challenge.repository.newpost.NewPostRepository;
import com.meli.spring_challenge.service.dto.NewPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductServiceImpl implements ProductService {

    @Autowired
    NewPostRepository newPostRepository;

    @Override
    public void createNewPost(NewPostDto newPostDto) {

    }
}
