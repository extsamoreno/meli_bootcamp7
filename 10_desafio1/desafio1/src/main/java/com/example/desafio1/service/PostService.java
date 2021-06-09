package com.example.desafio1.service;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.iPostRepository;
import com.example.desafio1.repository.iUserRepository;
import com.example.desafio1.service.dto.post.ResponseListFollowedSellers;
import com.example.desafio1.service.dto.post.ResponseListPostDTO;
import com.example.desafio1.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements iPostService {

    @Autowired
    iPostRepository iPostRepository;

    @Autowired
    iUserRepository iUserRepository;

    // Create a new post
    @Override
    public void createPost(Post post) throws PostAlreadyExistException, UserNotFoundException {
        iPostRepository.savePost(post);
    }

    // Get a list of the posts made by the sellers that a user follows (post made last weeks)
    @Override
    public ResponseListFollowedSellers listPostsFollowed(Integer userId) throws UserNotFoundException {

        ResponseListFollowedSellers listFollowedSellerDTO = new ResponseListFollowedSellers();
        User followerUser = iUserRepository.findUserById(userId);

        // Creating list with sellers followed
        for (User seller : followerUser.getFollows()) {

            ResponseListPostDTO listPostDTO = new ResponseListPostDTO();
            listPostDTO.setUserId(seller.getUserId());

            // Creating list with seller posts
            for (Post p : iPostRepository.findWeeksPostsByUserId(seller.getUserId(), 2)) {
                listPostDTO.getPosts().add(PostMapper.postToDto(p));
            }

            listFollowedSellerDTO.getListFollowersPosts().add(listPostDTO);
        }
        return listFollowedSellerDTO;
    }
}
