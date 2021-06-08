package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Repositories.IPostRepository;
import com.spring.desafioSpring.Services.Mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPosttRepository;

    @Override
    public void insertPost(PostDTO postDTO) throws PostIdExistsException {
        iPosttRepository.insertPost(PostMapper.postDtoToPost(postDTO));
    }
}
