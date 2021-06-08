package com.meli.socialmeli.repository;

import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.model.UserMeli;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository implements IUserRepository {


    private static HashMap<Integer, UserMeli> users = new HashMap<>();

    static {
        users.put(1, new UserMeli(1, "comprador1"));
        users.put(2, new UserMeli(2, "vendedor1"));
        users.put(3, new UserMeli(3, "comprador2"));
        users.put(4, new UserMeli(4, "vendedor"));
    }

    @Override
    public void follow(int userId, int userIdToFollow) {
        if (!users.get(userId).getFollowers().contains(users.get(userIdToFollow))) {
            users.get(userId).getFollowers().add(users.get(userIdToFollow));
        }
//        if (!users.get(userIdToFollow).getFollowed().contains(users.get(userId))) {
//            users.get(userIdToFollow).getFollowed().add(users.get(userId));
//        }
    }


    @Override
    public void saveUser(int userId, String userName) {
        users.put(users.size() + 1, new UserMeli(userId, userName));
    }

    @Override
    public UserMeli ListUser(int userId) {
        return users.get(userId);
    }

    @Override
    public UserResponseDTO getFollowersById(Integer userId) {
        //return new UserResponseDTO(44, "jjjj", 4);//
        return new UserResponseDTO(users.get(userId).getUserId(), "users.get(userId).getUserName()", 55);// users.get(userId).getFollowed().size());

    }
}
