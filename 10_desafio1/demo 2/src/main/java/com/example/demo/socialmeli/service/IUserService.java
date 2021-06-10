package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.exception.FollowedExistingException;
import com.example.demo.socialmeli.exception.FollowedNotExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.FollowedListDTO;
import com.example.demo.socialmeli.service.dto.FollowersListDTO;
import com.example.demo.socialmeli.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IUserService {
    HttpStatus follow(int userId,int useridToFollow) throws UserNotFoundException, FollowedExistingException;
    int getCountFollowers (int id);
    ArrayList<UserDTO> getList (int id, boolean isFollowed) throws UserNotFoundException;
    CountFollowersDTO countFollowers (int userId) throws UserNotFoundException;
    FollowersListDTO getFollowerList(int userId, String order) throws UserNotFoundException;
    FollowedListDTO getFollowedList(int userId, String order) throws UserNotFoundException;
    HttpStatus unFollow(int userId,int useridToUnFollow) throws UserNotFoundException, FollowedNotExistingException;
}
