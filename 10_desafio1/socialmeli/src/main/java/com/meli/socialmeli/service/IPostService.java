package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.SocialExceptionMissingParameter;
import com.meli.socialmeli.exception.SocialExceptionUserNotExists;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    void addPost(PostDTO post);

    List<PostDTO> getListPostByUserId(int userId);

    List<PostDTO> getListPromoPostByUserId(int userId);

    PostFollowingDTO getListPostUsersFollowingByUserId(int userId, String order) throws SocialExceptionUserNotExists, SocialExceptionMissingParameter;

    PostFollowingDTO getListPromoPostUsersFollowingByUserId(int userId, String order) throws SocialExceptionUserNotExists;


}
