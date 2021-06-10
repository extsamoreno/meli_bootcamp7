package com.reto1.demo.Repository;

import com.reto1.demo.Exception.UserException.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.User;

public interface IFollowRepository {

    String follow(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException;

    User getUserById(int userId) throws UserIdNotFoundException, UserNotFollowException;

    String unfollow(int userId, int userIdToUnFollow) throws UserIdNotFoundException, UserNotFollowException;

}