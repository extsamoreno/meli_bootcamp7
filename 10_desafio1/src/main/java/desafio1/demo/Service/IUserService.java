package desafio1.demo.Service;

import desafio1.demo.Exception.UserAlreadyFollowsException;
import desafio1.demo.Exception.UserCantFollowHimselfException;
import desafio1.demo.Exception.UserDoesNotFollowException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.FollowedListDTO;
import desafio1.demo.Model.DTO.FollowersCountDTO;
import desafio1.demo.Model.DTO.FollowersListDTO;

public interface IUserService {
    void followUser(int userId, int userIdToFollow) throws UserNotFoundException, UserAlreadyFollowsException, UserCantFollowHimselfException;
    void unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserDoesNotFollowException;
    FollowersCountDTO getFollowersCountById(int userId) throws UserNotFoundException;
    FollowersListDTO getFollowersListById(int userId, String order) throws UserNotFoundException;
    FollowedListDTO getFollowedListById(int userId, String order) throws UserNotFoundException;
}
