package com.desafiospring.socialMeli.service;

import com.desafiospring.socialMeli.dto.PostDTO;
import com.desafiospring.socialMeli.dto.FollowedPostDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;

import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;
import com.desafiospring.socialMeli.repository.ISocialMeliRepository;
import com.desafiospring.socialMeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    ISocialMeliRepository socialMeliRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException {
        socialMeliRepository.findUserById(post.getUserId());
        socialMeliRepository.addNewPost(PostMapper.toPost(post));
    }


    @Override
    public FollowedPostDTO getFollowedPosts(int userId, String order) throws UserNotFoundException {

        User user = socialMeliRepository.findUserById(userId);
        List<User> usersFollowed = socialMeliRepository.getFollowedList(userId);
        List<Post> postList = socialMeliRepository.getFollowedPosts(usersFollowed, order);

        return new FollowedPostDTO(user.getUserId(), postList);
    }


}
