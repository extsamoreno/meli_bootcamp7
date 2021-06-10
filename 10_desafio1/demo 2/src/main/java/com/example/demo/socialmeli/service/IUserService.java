package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowedListDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import com.example.demo.socialmeli.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IUserService {
    HttpStatus follow(int userId,int useridToFollow);
    int getCountFollowers (int id);
    ArrayList<UserDTO> getList (int id, boolean isFollowed);
    CountFollowersDTO countFollowers (int userId);
    FollowersListDTO getFollowerList(int userId, String order);
    FollowedListDTO getFollowedList(int userId, String order);
    HttpStatus unFollow(int userId,int useridToUnFollow);
}
