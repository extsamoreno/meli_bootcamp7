package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.UserDTO;

public interface IFollowService {

    String followOtherUser(int userId, int userIdToFollow) throws UserIdNotFoundException;

    UserDTO countFollowers(int userId) throws UserIdNotFoundException;
}
