package com.example.desafio1.service;

import JavaUtils.JavaUtils;
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

    // Returns a list of the posts made by sellers that a user followed (post made last weeks)
    @Override
    public ResponseListFollowedSellers listPostsFollowed(Integer userId, String order) throws UserNotFoundException {

        ResponseListFollowedSellers listFollowedSellerDTO = new ResponseListFollowedSellers();
        User followerUser = iUserRepository.findUserById(userId);

        // Creating list with sellers followed
        for (User seller : followerUser.getFollows()) {

            // Get last sellers posts
            ResponseListPostDTO listPostDTO = lastSellerPosts(seller.getUserId(), order);
            listFollowedSellerDTO.getListFollowersPosts().add(listPostDTO);
        }
        return listFollowedSellerDTO;
    }

    // Returns a list with last seller posts (weeksToFind is a filter) and ordered by date (asc/desc)
    @Override
    public ResponseListPostDTO lastSellerPosts(Integer userId, String order) throws UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(userId);
        ResponseListPostDTO sellerPosts = new ResponseListPostDTO();

        // Creating list with last seller posts (last 2 weeks to filter)
        for (Post p : iPostRepository.findNewerPostsByUserId(sellerUser.getUserId(), 2)) {
            sellerPosts.getPosts().add(PostMapper.postToDto(p));
        }

        // Order posts by date (asc/desc)
        if(order.equals("date_asc")){
            JavaUtils.orderByDateAsc(sellerPosts.getPosts());
        }else if(order.equals("date_desc")) {
            JavaUtils.orderByDateDesc(sellerPosts.getPosts());
        }
        return sellerPosts;
    }
}
