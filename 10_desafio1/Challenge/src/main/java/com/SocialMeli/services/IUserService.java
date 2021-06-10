package com.SocialMeli.services;

import com.SocialMeli.dtos.*;
import com.SocialMeli.FollowerCountDTO;
import com.SocialMeli.exceptions.UnhandledException;
import com.SocialMeli.exceptions.UserException;
import com.SocialMeli.exceptions.UserIdFollowerEqualsFollowed;
import com.SocialMeli.exceptions.UserIdInvalidException;
import com.SocialMeli.exceptions.UserIdNotFoundException;
import com.SocialMeli.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserService {

    Boolean follow (Integer userID, Integer useridtofollow);
    String followUser(int userId, int userIdToFollow) throws UserException;
    String FollowersCountDTO (int userId) throws UserNotFoundException;





    /* Object followUserDTO(int userId, int followedId);

    FollowedUserDTO addFollowUser(int userId, int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException;

    FollowerCountDTO findFollowersCount(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    FollowerUserDTO findFollowersByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    FollowUserDTO findFollowedByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    FollowedUserDTO unfollowUser(int userId, int userIdToUnfollow) throws UserIdFollowerEqualsFollowed, UserIdInvalidException, UserNotFoundException, UnhandledException;
*/

}

