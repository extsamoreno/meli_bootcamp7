package com.meli.desafio.repository;

import com.meli.desafio.exceptions.UserNotFoundException;
import com.meli.desafio.mappers.UserMapper;
import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.UserDTO;
import com.meli.desafio.utils.DataBase;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private List<User> listUsers = DataBase.listUsers;

    @Override
    public User getById(Integer userId) throws UserNotFoundException {
        List<User> user = listUsers.stream().filter(u -> u.getId() == userId).collect(Collectors.toList());
        if (user.size() == 0) {
            throw new UserNotFoundException(userId);
        }
        return user.get(0);
    }

    @Override
    public User getByName(String userName) throws UserNotFoundException {
        User user = listUsers.stream().filter(u -> u.getUserName() == userName).collect(Collectors.toList()).get(0);
        if (user == null) {
            throw new UserNotFoundException(userName);
        }
        return user;
    }

    @Override
    public List<UserDTO> getFollowersTo(User user) {
        List<UserDTO> userList = new ArrayList<>();
        for (User u : listUsers){
            for(UserDTO uDTO : u.getFollowed()){
                if(uDTO.getId() == user.getId()){
                    userList.add(UserMapper.userToDTO(u));
                }
            }
        }

        return userList;
    }
}
