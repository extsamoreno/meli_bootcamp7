package desafio1.desafio1.service.userService;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.*;
import desafio1.desafio1.service.userService.dto.SellerCountDTO;
import desafio1.desafio1.service.userService.dto.SellerListDTO;
import desafio1.desafio1.service.userService.dto.UserListDTO;

public interface IUsersService {
    User follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowException, FollowLoopException;

    SellerCountDTO countFollowersUserById(int userId) throws UserNotFoundException, ValidateSellerException;

    SellerListDTO listFollowersSeller(int userID, String order) throws UserNotFoundException, ValidateSellerException;

    UserListDTO listFollowedUser(int userId, String order) throws UserNotFoundException, ValidateUserException;

    void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException;
}
