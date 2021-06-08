package com.spring.desafioSpring.Services;

import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;

public interface IPostService {
    void insertPost(PostDTO post) throws PostIdExistsException;
}
