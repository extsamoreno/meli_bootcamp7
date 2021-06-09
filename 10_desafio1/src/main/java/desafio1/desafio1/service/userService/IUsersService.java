package desafio1.desafio1.service.userService;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.exception.userException.ValidateUserException;
import desafio1.desafio1.service.userService.dto.SellerCountDTO;
import desafio1.desafio1.service.userService.dto.SellerListDTO;
import desafio1.desafio1.service.userService.dto.UserListDTO;

public interface IUsersService {
    User follow(int userId, int userIdToFollow) throws UserNotFoundException;

    SellerCountDTO countFollowersUserById(int userId) throws UserNotFoundException, ValidateSellerException;

    SellerListDTO listFollowersSeller(int userID) throws UserNotFoundException, ValidateSellerException;

    UserListDTO listFollowedUser(int userId) throws UserNotFoundException, ValidateUserException;
}
