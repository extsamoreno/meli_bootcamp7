package desafio1.desafio1.repository;

import desafio1.desafio1.domain.Publications;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UnfollowException;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.service.userService.dto.UserSaveDTO;

import java.util.List;

public interface IUserRepository {
    User findUserById(int userId) throws UserNotFoundException;
    List<UserSaveDTO> filterFollowers(int userId, int criterio) throws UserNotFoundException;
    List<UserSaveDTO> filterFollowersMe(int userId, int criterio) throws UserNotFoundException;
    List<Publications> findPublicationByUserID(int userID) throws UserNotFoundException;
    void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException;
}
