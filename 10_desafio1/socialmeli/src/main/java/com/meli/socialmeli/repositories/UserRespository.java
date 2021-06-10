package com.meli.socialmeli.repositories;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.exceptions.UserDoNotExistsException;
import com.meli.socialmeli.exceptions.UserInvalidException;
import com.meli.socialmeli.exceptions.UserIsNotMerchant;
import com.meli.socialmeli.exceptions.UserNotFoundException;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.Product;
import com.meli.socialmeli.models.UserMeli;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class UserRespository implements IUserRepository {

    protected static HashMap<Integer, UserMeli> users = new HashMap<>();

    static {
        Product detail = new Product(123, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Post post = new Post(1, 18, "05-06-2021", detail, 100, 1500.50);
        Post post1 = new Post(1, 22, "30-05-2021", detail, 100, 1500.50);
        Post post2 = new Post(1, 22, "04-04-2020", detail, 100, 1500.50);

        users.put(1, new UserMeli(1, "Vendedor1", post));
        users.get(1).setMerchant(true);
        users.get(1).getPosts().add(post1);
        users.get(1).getPosts().add(post2);
        users.get(1).getFollowers().add(3);
        users.get(1).getFollowers().add(4);

        users.put(2, new UserMeli(2, "Comprador2"));

        users.put(3, new UserMeli(3, "Comprador3"));
        users.get(3).getFollowedBy().add(1);
        users.get(3).getFollowedBy().add(5);

        users.put(4, new UserMeli(4, "Comprador4"));
        users.get(4).getFollowedBy().add(1);
        users.get(4).getFollowedBy().add(5);

        users.put(5, new UserMeli(5, "Vendedor5"));
        users.get(5).setMerchant(true);
        users.get(5).getPosts().add(post1);
        users.get(5).getPosts().add(post2);
        users.get(5).getFollowers().add(3);
        users.get(5).getFollowers().add(4);


    }

    @Override
    public UserMeli followMerchant(int userId, int userIdToFollow) throws UserInvalidException, UserIsNotMerchant, UserDoNotExistsException {
        if(!users.containsKey(userIdToFollow)){
            throw new UserDoNotExistsException();
        }
        if (!users.get(userIdToFollow).isMerchant()){
            throw new UserIsNotMerchant(userIdToFollow);
        }
        if (!users.get(userId).getFollowedBy().contains((Integer) users.get(userIdToFollow).getUserId())
        ) {
            users.get(userId).getFollowedBy().add(users.get(userIdToFollow).getUserId());
            users.get(userIdToFollow).getFollowers().add(users.get(userId).getUserId());
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
    public UserResponseDTO getFollowerById(int userId) {

        return UserMapper.UserMeliToUSerResponseDTO(users.get(userId));
    }

    @Override
    public ArrayList<UserResponseDTO> getFollowersById(int userId, String order) {
        ArrayList<UserResponseDTO> followDTOArrayList = new ArrayList<>();

        ArrayList<Integer> listIdFollowers = users.get(userId).getFollowers();

        for (Integer idUser : listIdFollowers
        ) {
            followDTOArrayList.add(getFollowerById(idUser));
        }

        return sorterUserNames(followDTOArrayList, order);
    }

    private ArrayList<UserResponseDTO> sorterUserNames(ArrayList<UserResponseDTO> list, String s) {
        if (s.equals("name_asc")) {
            return (ArrayList<UserResponseDTO>) list.stream()
                    .sorted((o1, o2) -> o1.getUserName().compareTo(o2.getUserName()))
                    .collect(Collectors.toList());
        }
        if (s.equals("name_desc")) {
            return (ArrayList<UserResponseDTO>) list.stream()
                    .sorted((o2, o1) -> o1.getUserName().compareTo(o2.getUserName()))
                    .collect(Collectors.toList());
        } else {
            return list;
        }
    }

    @Override
    public UserFollowerListDTO getListFollowersById(int userId, String order) {
        return new UserFollowerListDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), getFollowersById(userId, order));
    }

    @Override
    public UserFollowedByListDTO getListFollowedById(int userId, String order) {
        return new UserFollowedByListDTO(users.get(userId).getUserId(), users.get(userId).getUserName(), getFollowedById(userId, order));
    }

    @Override
    public UserMeli unfollowMerchant(int userId, int userIdToFollow) throws UserNotFoundException {
        if (users.get(userId).getFollowers().contains(users.get(userIdToFollow).getUserId())) {
            users.get(userId).getFollowers().remove(Integer.valueOf(users.get(userIdToFollow).getUserId()));
            users.get(userIdToFollow).getFollowedBy().remove(Integer.valueOf(users.get(userId).getUserId()));
        } else {
            throw new UserNotFoundException();
        }
        return users.get(userId);
    }

    private ArrayList<UserResponseDTO> getFollowedById(int userId, String order) {
        ArrayList<UserResponseDTO> followDTOArrayList = new ArrayList<>();

        ArrayList<Integer> listIdFollowedBy = users.get(userId).getFollowedBy();

        for (Integer idUser : listIdFollowedBy
        ) {
            followDTOArrayList.add(getFollowerById(idUser));
        }

        return sorterUserNames(followDTOArrayList, order);
    }
}
