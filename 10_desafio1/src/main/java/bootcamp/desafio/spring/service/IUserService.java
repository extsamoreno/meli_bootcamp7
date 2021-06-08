package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.UserNotFoundException;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.service.dto.UserCountFollowersDTO;
import bootcamp.desafio.spring.service.dto.UserDTO;

import java.util.ArrayList;

public interface IUserService {


    void follow(Long userId, Long sellerId) throws UserNotFoundException;

    UserCountFollowersDTO countFollowers(Long userId) throws UserNotFoundException;

    ArrayList<UserDTO> getFollowers(Long userId);
}
