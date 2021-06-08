package com.example.socialmeli.repositories;

import com.example.socialmeli.dtos.*;
import com.example.socialmeli.exceptions.FollowAlreadyExistException;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.mappers.SocialMapper;
import com.example.socialmeli.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SocialRepository implements ISocialRepository{
    private HashMap<Integer, MerchantDTO> merchantsMap = new HashMap<>();
    private HashMap<Integer, UserDTO> usersMap = new HashMap<>();

    @Override
    public MerchantDTO createMerchant(String name) {
        MerchantDTO merchantDTO = new MerchantDTO();

        merchantDTO.setId(merchantsMap.size()+1);
        merchantDTO.setFollowCount(0);
        merchantDTO.setName(name);

        merchantsMap.put(merchantsMap.size()+1,merchantDTO );

        return merchantDTO;
    }

    @Override
    public MerchantDTO followMerchant(Integer userid, Integer merchantId) throws MerchantNotFoundException, FollowAlreadyExistException {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(userid);
        userDTO.setName("User"+userid);

        usersMap.put(userid, userDTO);

        // update follow on merchant
        for (Integer i = 1; i < merchantsMap.size()+1; i++) {
            Integer merchantMapId = merchantsMap.get(i).getId();

            if (merchantMapId == merchantId){

                if(alreadyFollow(userid,merchantMapId)){
                    throw new FollowAlreadyExistException("The user already follow the merchant", HttpStatus.CONFLICT);
                }

                MerchantDTO merchantDTO = merchantsMap.get(i);

                merchantDTO.setFollowCount(merchantsMap.get(i).getFollowCount()+1);

                User userDTOtoModel = SocialMapper.usserDTOtoModel(userDTO);

                List<User> merchantUser = merchantDTO.getUsers();

                if (merchantUser == null){
                    merchantUser = new ArrayList<>();
                }

                merchantUser.add(userDTOtoModel);

                merchantDTO.setUsers(merchantUser);

                return merchantDTO;
            }
        }

        throw new MerchantNotFoundException("MerchantID does not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public FollowersCountDTO followersCount(Integer merchantid, String name) throws MerchantNotFoundException {
        FollowersCountDTO followersCountDTO = new FollowersCountDTO();

        MerchantDTO merchantDTO = merchantsMap.get(merchantid);

        if (merchantDTO == null){
            throw new MerchantNotFoundException("MerchantID does not exist", HttpStatus.BAD_REQUEST);
        }

        followersCountDTO.setId(merchantid);
        followersCountDTO.setCount(merchantDTO.getFollowCount());
        followersCountDTO.setName(name);

        return followersCountDTO;
    }

    @Override
    public FollowersListDTO followersList(Integer merchantid, String name) throws MerchantNotFoundException {
        FollowersListDTO followersListDTO = new FollowersListDTO();

        MerchantDTO merchantDTO = merchantsMap.get(merchantid);

        if (merchantDTO == null){
            throw new MerchantNotFoundException("MerchantID does not exist", HttpStatus.BAD_REQUEST);
        }

        followersListDTO.setId(merchantid);
        followersListDTO.setFollowers(merchantDTO.getUsers());
        followersListDTO.setName(name);

        return followersListDTO;
    }

    @Override
    public FollowedByMeListDTO followedByMe(Integer merchantid, String name) throws UserNotFoundException {
        FollowedByMeListDTO followedByMeListDTO = new FollowedByMeListDTO();

        MerchantDTO merchantDTO = merchantsMap.get(merchantid);

        if (merchantDTO == null){
            throw new UserNotFoundException("UserId does not exist", HttpStatus.BAD_REQUEST);
        }

        followedByMeListDTO.setId(merchantid);
        followedByMeListDTO.setFollowers(merchantDTO.getUsers());
        followedByMeListDTO.setName(name);

        return followedByMeListDTO;
    }

    public boolean alreadyFollow(Integer userId, Integer merchantId){
        MerchantDTO merchantDTO = merchantsMap.get(merchantId);
        List<User> merchantUser = merchantDTO.getUsers();

        if (merchantUser == null){
            merchantUser = new ArrayList<>();
        }

        for (int i = 0; i < merchantUser.size(); i++) {
            Integer userMapId = merchantUser.get(i).getId();

            if (userId == userMapId){
                return true;
            }
        }

        return false;
    }
}