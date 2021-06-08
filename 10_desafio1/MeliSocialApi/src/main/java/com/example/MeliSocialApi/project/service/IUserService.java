package com.example.MeliSocialApi.project.service;

import com.example.MeliSocialApi.project.exception.UserNotFoundException;
import com.example.MeliSocialApi.project.service.dto.FollowersUserDTOResponse;
import com.example.MeliSocialApi.project.service.dto.UserFollowersCountDTOResponse;

public interface IUserService {
    boolean follow(Integer idUser, Integer idUserToFollow) throws UserNotFoundException;
    UserFollowersCountDTOResponse getFollowersCount(Integer idUser) throws UserNotFoundException;
    FollowersUserDTOResponse getFollowersList(Integer idUser) throws UserNotFoundException;
}
