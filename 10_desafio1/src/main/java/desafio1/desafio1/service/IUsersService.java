package desafio1.desafio1.service;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.UserNotFoundException;
import desafio1.desafio1.exception.ValidateSellerException;
import desafio1.desafio1.exception.ValidateUserException;
import desafio1.desafio1.service.dto.SellerCountDTO;
import desafio1.desafio1.service.dto.list.SellerListDTO;
import desafio1.desafio1.service.dto.list.UserListDTO;

public interface IUsersService {
    User follow(int userId, int userIdToFollow) throws UserNotFoundException;

    SellerCountDTO countFollowersUserById(int userId) throws UserNotFoundException, ValidateSellerException;

    SellerListDTO listFollowersSeller(int userID) throws UserNotFoundException, ValidateSellerException;

    UserListDTO listFollowedUser(int userId) throws UserNotFoundException, ValidateUserException;
}
