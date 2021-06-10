package com.meli.socialmeli.service.post;

import com.meli.socialmeli.dto.post.*;
import com.meli.socialmeli.dto.user.UserPromoPostsDTO;
import com.meli.socialmeli.exception.InvalidDateException;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.ProductAlreadyPostedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.post.IPostRepository;
import com.meli.socialmeli.repository.user.IUserRepository;
import com.meli.socialmeli.service.mapper.PostMapper;
import com.meli.socialmeli.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void addPost(PostDTO newPost) throws UserIdNotFoundException, PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException {
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
        return new FollowedPostsDTO(userId, PostMapper.toPostsDTO(iPostRepository.getFollowedPosts(followed,order)));
    }

    @Override
    public void addPromoPost(PostDTO newPromoPost) throws UserIdNotFoundException, PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException {
        if(iUserRepository.findUserById(newPromoPost.getUserId()) == null) {
            throw new UserIdNotFoundException(newPromoPost.getUserId());
        }

        iPostRepository.insertPost(PostMapper.toPost(newPromoPost));
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

        return new UserPromoPostsDTO(user.getUserId(), user.getUserName(), PostMapper.toPostsDTO(iPostRepository.getPromoPosts(userId)));
    }
}
