package com.example.demo.project.service;


import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.exception.UsersCantFollowThemselvesException;
import com.example.demo.project.service.dto.SellerDTO;
import com.example.demo.project.service.dto.UserDTO;

import java.util.Optional;

public interface IUserService {

    void follow(int userid, int user_id_to_follow) throws UserIdNotFoundException, UsersCantFollowThemselvesException;
    void unfollow(int userid, int user_id_to_unfollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException;
    SellerDTO getFollowerCount(int user_id) throws UserIdNotFoundException;
    SellerDTO getFollowers(int user_id, Optional<String> order) throws UserIdNotFoundException;
    UserDTO getFollowingCount(int user_id) throws UserIdNotFoundException;
    UserDTO getFollowing(int user_id, Optional<String> order) throws UserIdNotFoundException;

}
