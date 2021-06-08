package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.UserDTOCount;
import com.reto1.demo.Model.DTO.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserDTOFollowers;
import com.reto1.demo.Model.Post;

import java.util.ArrayList;

public interface IFollowService {

    String followOtherUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException;

    UserDTOCount countFollowers(int userId) throws UserIdNotFoundException;

    UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException;

    UserDTOFolloweds getFolloweds(int userID) throws UserIdNotFoundException;

    String creatPost(Post post) throws UserIdNotFoundException;
}
