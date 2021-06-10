package com.reto1.demo.Service;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserException.SameIdException;
import com.reto1.demo.Exception.UserException.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOCount;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFollowers;
import com.reto1.demo.Model.DTO.UserObjets.UserRequest;

public interface IFollowService {

    String followOtherUser(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException, UserAlreadyFollowException, SameIdException;

    UserDTOCount countFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException, UserIdNotFoundException, UserNotFollowException;

    UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException;

    UserDTOFolloweds getFolloweds(int userID) throws UserIdNotFoundException, UserNotFollowException;

    String unFollow(int userId, int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException;

    UserDTOFollowers orderListFollowers(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;

    UserDTOFolloweds orderListFolloweds(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;

    int createUser(UserRequest user);
}
