package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.DTOS.CreateUserDTO;
import com.Desafio1.SocialMeli.DTOS.UserDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.Post;
import com.Desafio1.SocialMeli.Models.User;

import java.util.List;

public interface IUserRepository {
    List<User> createUser(CreateUserDTO createUserDTO) throws DuplicateIdException;
    void updateUser(User seller);
    List<User> readUsers();
    User searchUserById(int userId) throws UserNotFoundException;
    void followSeller(User buyer, User seller) throws UserNotFoundException, DuplicateIdException;
    List<Post> getFollowedPostList(List<UserDTO> followed) throws UserNotFoundException;
    void unFollowSeller(User buyer, User seller);
}
