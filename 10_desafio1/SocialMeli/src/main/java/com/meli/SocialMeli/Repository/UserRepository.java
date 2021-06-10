package com.meli.SocialMeli.repository;

import com.meli.SocialMeli.dto.CreateUserDto;
import com.meli.SocialMeli.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{
    private List<User> userList;

    public UserRepository (){
        this.userList = new ArrayList<>();
    }

    @Override
    public List<User> CreateUser(CreateUserDto createUserDto) {
        this.userList = createUserDto.getCreateDto();
        return userList;
    }

    @Override
    public User SearchIdUser(int idUser) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (idUser == user.getIdUser()) {
                return user;
            }
        }
        return null;
    }


    @Override
    public void UpdateUserList(User user){
        int index;
        index = userList.indexOf(user);
        userList.set(index, user);
    }

    @Override
    public List<User> getUsers() {
        return this.userList;
    }

    @Override
    public int FollowUser(int userId, int userIdToFollow) {
        return 0;
    }

    public List<User> getFollowersCount(){
        return this.userList;
    }

}
