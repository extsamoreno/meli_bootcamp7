package com.meli.socialmeli.repositories;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.FollowDTO;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRespository implements IUserRepository{

    private static HashMap<Integer, UserMeli> users = new HashMap<>();

    static {
        users.put(1, new UserMeli(1, "comprador1"));
        users.put(2, new UserMeli(2, "vendedor1"));
        users.put(3, new UserMeli(3, "comprador2"));
        users.put(4, new UserMeli(4, "vendedor"));
    }

    @Override
    public UserMeli followMerchant(int userId, int userIdToFollow) {
        if (!users.get(userId).getFollowers().contains(users.get(userIdToFollow))) {
            users.get(userId).getFollowers().add(users.get(userIdToFollow).getUserId());
        }
        return users.get(userId);
    }

    @Override
    public UserMeli getFollowerCountById(int userId) {
        return users.get(userId);
    }

    @Override
    public UserMeli getFollowerListById(int userId) {
        return null;
    }

    @Override
    public UserResponseDTO getFollowerById(int userId) {
        return UserMapper.UserMeliToUSerResponseDTO(users.get(userId));
    }

    @Override
    public ArrayList<UserResponseDTO> getFollowersById(int userId) {
        ArrayList<UserResponseDTO> followDTOArrayList = new ArrayList<>();

        ArrayList<Integer> listIdFollowers = users.get(userId).getFollowers() ;

        for (Integer idUser: listIdFollowers
             ) {
            followDTOArrayList.add(getFollowerById(idUser));
        }

        return followDTOArrayList;
    }

    @Override
    public UserFollowerListDTO getListFolloweraById(int userId) {
        return new UserFollowerListDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), getFollowersById(userId));
    }
}
