package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import com.socialmeli.socialmeli.services.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException {
        userRepository.insertPost(
                PostMapper.getPost(post)
        );
    }

}
