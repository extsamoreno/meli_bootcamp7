package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.entity.User;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.repository.PostRepository;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addNewPost(NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        User user = userRepository.getUserById(request.getUserId());
        if (user == null) {
            throw new UserIdNotFoundException();
        }
       postRepository.addNewProduct(PostMapper.toPost(request));
    }
}
