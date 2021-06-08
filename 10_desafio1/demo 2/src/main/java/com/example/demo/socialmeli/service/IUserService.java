package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    public HttpStatus follow(int userid,int useridtofollow);
    public CountFollowersDTO countFollowers (int userid);
    public FollowersListDTO followerList (int userid);
}
