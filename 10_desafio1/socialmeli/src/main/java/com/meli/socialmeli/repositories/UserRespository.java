package com.meli.socialmeli.repositories;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.exceptions.UserNotFoundException;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.Product;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class UserRespository implements IUserRepository{

    protected static HashMap<Integer, UserMeli> users = new HashMap<>();

    static {
        Product detail = new Product(123, "Silla Gamer", "Gamer", "Racer","Red & Black", "Special Edition");
        Post post = new Post(1, 18, "29-04-2021", detail, 100, 1500.50);
//        int product_id;         //: 1,
//        String productName;     // : "Silla Gamer",
//        String type;            // : "Gamer",,
//        String brand;           //: "Racer"
//        String color;           //" : "Red & Black",
//        String notes;           // : "Special Edition"
//
//        int userId;         //: 1235,
//        int id_post;        // : 18,
//        String date;        // : "29-04-2021",
//        Product detail;
//        int category;       // :100,
//        double price;       // :1500.50

        users.put(1, new UserMeli(1, "comprador1", post));
        users.put(2, new UserMeli(2, "vendedor1"));
        users.put(3, new UserMeli(3, "comprador2"));
        users.put(4, new UserMeli(4, "vendedor"));
    }

    @Override
    public UserMeli followMerchant(int userId, int userIdToFollow) throws UserInvalidException {
        if (!users.get(userId).getFollowers().contains(users.get(userIdToFollow))) {
            users.get(userId).getFollowers().add(users.get(userIdToFollow).getUserId());
            users.get(userIdToFollow).getFollowedBy().add(users.get(userId).getUserId());
        } else {
            throw new UserInvalidException();
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
    public UserFollowerListDTO getListFollowersById(int userId) {
        return new UserFollowerListDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), getFollowersById(userId));
    }

    @Override
    public UserFollowedByListDTO getListFollowedById(int userId) {
        return new UserFollowedByListDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), getFollowedById(userId));
    }

    @Override
    public UserMeli unfollowMerchant(int userId, int userIdToFollow) throws UserNotFoundException {
        if (users.get(userId).getFollowers().contains(users.get(userIdToFollow))) {
            //int index = new Integer(users.get(userIdToFollow).getUserId());
            users.get(userId).getFollowers().remove(Integer.valueOf(users.get(userIdToFollow).getUserId()));
            users.get(userIdToFollow).getFollowedBy().remove(Integer.valueOf(users.get(userId).getUserId()));
        }
        else {
            throw new UserNotFoundException();
        }
        return users.get(userId);
    }

    private ArrayList<UserResponseDTO> getFollowedById(int userId) {
        ArrayList<UserResponseDTO> followDTOArrayList = new ArrayList<>();

        ArrayList<Integer> listIdFollowedBy = users.get(userId).getFollowedBy() ;

        for (Integer idUser: listIdFollowedBy
        ) {
            followDTOArrayList.add(getFollowerById(idUser));
        }

        return followDTOArrayList;
    }
}
