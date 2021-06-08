package desafio1.desafio1.repository;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.UserNotFoundException;


public interface IUserRepository {
    User findUserById(int userId) throws UserNotFoundException;
}
