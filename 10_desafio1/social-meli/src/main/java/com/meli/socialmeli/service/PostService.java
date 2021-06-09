package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.*;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void addPost(NewPostDTO newPost) throws UserIdNotFoundException {
        if(iUserRepository.findUserById(newPost.getUserId()) == null) {
            throw new UserIdNotFoundException(newPost.getUserId());
        }

        iPostRepository.insertPost(PostMapper.toPost(newPost));
    }

    @Override
    public FollowedPostsDTO getFollowedPosts(Integer userId, String order) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        List<User> followed = iUserRepository.getUserFollowed(userId,null);
        return new FollowedPostsDTO(userId, iPostRepository.getFollowedPosts(followed,order));
    }

    @Override
    public void addPromoPost(NewPromoPostDTO newPromoPost) throws UserIdNotFoundException {
        if(iUserRepository.findUserById(newPromoPost.getUserId()) == null) {
            throw new UserIdNotFoundException(newPromoPost.getUserId());
        }

        iPostRepository.insertPost(PostMapper.toPromoPost(newPromoPost));
    }

    @Override
    public PromoPostCount getPromoPostCount(Integer userId) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new PromoPostCount(user.getUserId(), user.getUserName(), iPostRepository.getPromoPosts(userId).size());
    }

    @Override
    public UserPromoPostsDTO getUserPromoPosts(Integer userId) throws UserIdNotFoundException {
        User user = iUserRepository.findUserById(userId);

        if(user == null) {
            throw new UserIdNotFoundException(userId);
        }

        return new UserPromoPostsDTO(user.getUserId(), user.getUserName(), iPostRepository.getPromoPosts(userId));
    }
}
