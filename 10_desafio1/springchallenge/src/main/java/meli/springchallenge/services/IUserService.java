package meli.springchallenge.services;

import meli.springchallenge.dtos.FollowerCountDTO;
import meli.springchallenge.dtos.FollowListDTO;
import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;

public interface IUserService {

    void addFollower(int follower, int following) throws UserNotValidException, RelationNotValidException;

    FollowerCountDTO countFollowers(int userId) throws UserNotValidException;

    FollowListDTO getFollowers(int userId) throws UserNotValidException;

    FollowListDTO getFollowed(int userId) throws UserNotValidException;
}
