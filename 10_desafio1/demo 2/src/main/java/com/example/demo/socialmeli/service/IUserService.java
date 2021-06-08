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
    HttpStatus follow(int userid,int useridtofollow);
    int getCountFollowers (int id);
    ArrayList<UserDTO> getList (int id, boolean isFollowed);
    CountFollowersDTO countFollowers (int userid);
    FollowersListDTO getFollowerList(int userid);
    FollowedListDTO getFollowedList(int userid);
}
