package com.example.desafio1.service;

import JavaUtils.JavaUtils;
import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.iPostRepository;
import com.example.desafio1.repository.iUserRepository;
import com.example.desafio1.service.dto.post.*;
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
        sellerPosts.setUserId(sellerUser.getUserId());

        // Creating list with last seller posts (last 2 weeks to filter)
        for (Post p : iPostRepository.findNewerPostsByUserId(sellerUser.getUserId(), 2)) {
            sellerPosts.getPosts().add(PostMapper.postToDto(p));
        }

        // Order posts by date (asc/desc)
        if (order.equals("date_asc")) {
            JavaUtils.orderByDateAsc(sellerPosts.getPosts());
        } else if (order.equals("date_desc")) {
            JavaUtils.orderByDateDesc(sellerPosts.getPosts());
        }
        return sellerPosts;
    }

    // Returns the amount of products in promotion from a seller (userId)
    @Override
    public ResponsePromoPostCountDTO countPromoPostSeller(Integer userId) throws UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(userId);
        ResponseListPromoDTO sellerPosts = new ResponseListPromoDTO();

        // Filter posts if has promo
        for (Post p : iPostRepository.findPostsByUserId(sellerUser.getUserId())) {
            if(p.isHasPromo()){
                sellerPosts.getPosts().add(PostMapper.postToPromoDTO(p));
            }
        }
        return new ResponsePromoPostCountDTO(sellerUser.getUserId(), sellerUser.getUserName(), sellerPosts.getPosts().size());
    }

    // Returns a list with promo posts (filtered by user)
    @Override
    public ResponseListPromoDTO listSellerPromoPosts(Integer userId, String order) throws UserNotFoundException {

        User sellerUser = iUserRepository.findUserById(userId);
        ResponseListPromoDTO sellerPosts = new ResponseListPromoDTO();
        sellerPosts.setUserId(sellerUser.getUserId());

        // Filter posts if has promo
        for (Post p : iPostRepository.findPostsByUserId(sellerUser.getUserId())) {
            if(p.isHasPromo()){
                sellerPosts.getPosts().add(PostMapper.postToPromoDTO(p));
            }
        }

        // Order posts by product name (asc/desc)
        if (order.equals("name_asc")) {
            JavaUtils.orderByPostNameAsc(sellerPosts.getPosts());
        } else if (order.equals("name_desc")) {
            JavaUtils.orderByPostNameDesc(sellerPosts.getPosts());
        }
        return sellerPosts;
    }
}
