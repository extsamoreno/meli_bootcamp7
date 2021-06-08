package desafio1.desafio1.service;

import desafio1.desafio1.exception.UserNotFoundException;
import desafio1.desafio1.exception.ValidateSellerException;
import desafio1.desafio1.service.dto.SellerDTO;
import desafio1.desafio1.service.dto.UserDTO;

public interface IUsersService {
    UserDTO follow(int userId, int userIdToFollow) throws UserNotFoundException;

    SellerDTO countFollowersById(int userId) throws UserNotFoundException, ValidateSellerException;
}
