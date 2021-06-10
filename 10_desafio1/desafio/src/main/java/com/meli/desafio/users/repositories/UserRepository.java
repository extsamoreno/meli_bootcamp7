package com.meli.desafio.users.repositories;

import com.meli.desafio.users.exceptions.UserNotFollowed;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.mappers.UserMapper;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.UserDTO;
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
    public List<Integer> getFollowersTo(User user) {
        List<Integer> userList = new ArrayList<>();
        for (User u : listUsers){
            for(Integer id: u.getFollowed()){
                if(id == user.getId()) userList.add(u.getId());
            }
        }

        return userList;
    }

    @Override
    public boolean userExist(Integer userId) {
        for(User u: listUsers){
            if(u.getId() == userId) return true;
        }
        return false;
    }

    @Override
    public void removeFollow(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, UserNotFollowed {
        User user = this.getById(userId);
        List<Integer> list = user.getFollowed();
        if(!list.contains(userIdToUnfollow))
            throw new UserNotFollowed(userIdToUnfollow);
        user.setFollowed(list.stream().filter(u -> u != userIdToUnfollow).collect(Collectors.toList()));
    }
}
