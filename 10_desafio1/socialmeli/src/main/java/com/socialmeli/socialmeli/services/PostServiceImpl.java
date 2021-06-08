package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.repositories.PostRepository;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import com.socialmeli.socialmeli.services.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public void newPost(PostDTO post) {
        postRepository.insertPost(
                PostMapper.getPost(post)
        );
    }

}
