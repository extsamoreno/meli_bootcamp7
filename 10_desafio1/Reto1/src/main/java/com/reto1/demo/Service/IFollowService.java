package com.reto1.demo.Service;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Exception.UserNotFollowException;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOCount;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFollowers;

public interface IFollowService {

    String followOtherUser(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException ;

    UserDTOCount countFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException;

    UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException;

    UserDTOFolloweds getFolloweds(int userID) throws UserIdNotFoundException, UserNotFollowException;

    String unFollow(int userId, int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException;

    UserDTOFollowers orderListFollowers(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;

    UserDTOFolloweds orderListFolloweds(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;
}
