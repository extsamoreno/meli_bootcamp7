package com.desafiospring.socialMeli.service;

import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.dto.FollowedPostDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;

import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;
import com.desafiospring.socialMeli.repository.IPostRepository;
import com.desafiospring.socialMeli.repository.IUserRepository;
import com.desafiospring.socialMeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException {
        userRepository.findUserById(post.getUserId());
        postRepository.addNewPost(PostMapper.toPost(post));
    }

    @Override
    public FollowedPostDTO getFollowedPosts(int userId, String order) throws UserNotFoundException {

        User user = userRepository.findUserById(userId);
        List<User> usersFollowed = userRepository.getFollowedList(userId);
        List<Post> postList = postRepository.getFollowedPosts(usersFollowed, order);

        return new FollowedPostDTO(user.getUserId(), postList);
    }

}
