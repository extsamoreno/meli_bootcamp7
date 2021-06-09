package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import com.socialmeli.socialmeli.services.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException, ParseException {
        userRepository.insertPost(
                PostMapper.getPost(post)
        );
    }

}
