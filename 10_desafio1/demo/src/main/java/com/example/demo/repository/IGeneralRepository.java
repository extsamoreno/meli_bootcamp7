package com.example.demo.repository;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PromoPostDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.UserNotFoundException;

import java.util.List;

public interface IGeneralRepository {

    UserDTO findById(Integer userId) throws UserNotFoundException;

    void follow(UserDTO userId, UserDTO userIdToFollow);

    Integer countFollowers(UserDTO user) ;

    List<UserDTO> followersList(Integer userId);

    List<UserDTO> followedList(Integer userID);

    void newPost (PostDTO post);

    List<PostDTO> findPostByUserId(Integer userId);

    void unfollow(UserDTO userId, UserDTO userIdToUnfollow) throws GenericException;

    void newPromoPost(PromoPostDTO promoPost) throws GenericException;

    Integer countPromo(UserDTO user);

    List<PromoPostDTO> getPromoList(UserDTO user);
}
