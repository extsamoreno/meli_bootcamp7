package com.example.Challenge.repository;

import com.example.Challenge.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class UserRepositoryImpl implements IUserRepository {

    //Initialize users
    public final HashMap<Integer, User> dataBaseUsers = new HashMap<>();
    User u1=new User(1,"user1", false);
    User u2=new User(2,"user2",false);
    User u3=new User(3,"user3",false);
    User u4=new User(4,"user4",false);
    User u5=new User(5,"user5", true);
    User u6=new User(6,"user6",true);
    User u7=new User(7,"user7",true);
    User u8=new User(8,"user8",true);

    //Add users to database
    public UserRepositoryImpl() {
        this.dataBaseUsers.put(1,u1);
        this.dataBaseUsers.put(2,u2);
        this.dataBaseUsers.put(3,u3);
        this.dataBaseUsers.put(4,u4);
        this.dataBaseUsers.put(5,u5);
        this.dataBaseUsers.put(6,u6);
        this.dataBaseUsers.put(7,u7);
        this.dataBaseUsers.put(8,u8);
    }

    @Override
    public User getUserById(Integer id) {
        User userResult= dataBaseUsers.get(id);
        return  userResult;
    }

    @Override
    public void saveChanges(User user) {
        dataBaseUsers.put(user.getIdUser(), user);
    }

}

