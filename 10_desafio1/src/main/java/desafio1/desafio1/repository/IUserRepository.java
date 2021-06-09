package desafio1.desafio1.repository;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.UserNotFoundException;
import desafio1.desafio1.service.dto.UserSaveDTO;

import java.util.List;


public interface IUserRepository {
    User findUserById(int userId) throws UserNotFoundException;
   List<UserSaveDTO> filterFollowers(int userId, String criterio) throws UserNotFoundException;
    List<UserSaveDTO> filterFollowersMe(int userId, String criterio) throws UserNotFoundException;


}
