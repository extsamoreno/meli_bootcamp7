package com.meli.socialmeli.repository;

import com.meli.socialmeli.dto.UserFollowerDTO;
import com.meli.socialmeli.dto.UserResponseCountDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.mapper.UserMapper;
import com.meli.socialmeli.model.UserMeli;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
            users.get(userId).getFollowers().add(users.get(userIdToFollow).getUserId());
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
    public UserFollowerDTO ListUser(int userId) {
        ArrayList<Integer> followers= users.get(userId).getFollowers();
        ArrayList<UserResponseDTO> followersList= null;
        for (Integer urd: users.get(followers).getFollowers()
                          ) {
            followersList.add(UserMapper.toDTO(users.get(followers)));
        }
        return new UserFollowerDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), followersList );
    }

//    @Override
//    public UserResponseCountDTO getFollowersById(int userId) {
//        return null;
//    }

    @Override
    public UserResponseCountDTO getFollowersById(int userId) {
        //return new UserResponseDTO(44, users.get(userId).getUserName(), 4);//
        return new UserResponseCountDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), 55);

    }
}
