package com.example.Challenge.service;

import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.mapper.MapperUser;
import com.example.Challenge.model.User;
import com.example.Challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserServiceImpl implements   IUserService{

    @Autowired
    IUserRepository iUserRepository;



    public void addFollower(User customer, User seller){
        List<UserDTO> usersFollowers = seller.getFollowers();
        if (customer!= null){
            usersFollowers.add(MapperUser.toUserDTO(customer));
            seller.setFollowers(usersFollowers);
            iUserRepository.saveChanges(customer);
            iUserRepository.saveChanges(seller);
        }
    }

    public void addFollowed(User customer, User seller){
        List<UserDTO> usersFollowed = customer.getFollowed();
        if(seller!= null){
            usersFollowed.add(MapperUser.toUserDTO(seller));
            customer.setFollowed(usersFollowed);
            iUserRepository.saveChanges(customer);
            iUserRepository.saveChanges(seller);
        }

    }

    public void deleteFollower(User customer, User seller){
        List<UserDTO> usersFollowers = seller.getFollowers();
        if (customer!= null){
            usersFollowers.remove(MapperUser.toUserDTO(customer));
            seller.setFollowers(usersFollowers);
            iUserRepository.saveChanges(customer);
            iUserRepository.saveChanges(seller);
        }
    }

    public void deleteFollowed(User customer, User seller){
        List<UserDTO> usersFollowed = customer.getFollowed();
        if(seller!= null){
            usersFollowed.remove(MapperUser.toUserDTO(seller));
            customer.setFollowed(usersFollowed);
            iUserRepository.saveChanges(customer);
            iUserRepository.saveChanges(seller);
        }

    }

    @Override
    public void Follow(Integer userId, Integer userToFollow) {

        User customer =  iUserRepository.getUserById(userId);
        User seller = iUserRepository.getUserById(userToFollow);
        addFollower(customer,seller);
        addFollowed(customer,seller);

    }

    @Override
    public UserResponseCountDTO getUserFollowersCount(Integer userId) {
        UserResponseCountDTO userResult = MapperUser.toUserResponseCountDTO(iUserRepository.getUserById(userId));
        return userResult;
    }

    @Override
    public UserResponseListDTO getUserFollowersList(Integer userId, String order) {
        UserResponseListDTO userResult = MapperUser.toUserResponseListDTO(iUserRepository.getUserById(userId));
        if(order== null){
            return userResult;
        }
        else if(order.equals("name_asc")){
            //Sort by Name
            Collections.sort(userResult.getListFollowers(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            return userResult;
        }
        else if(order.equals("name_desc")){
            //Sort by Name
            Collections.sort(userResult.getListFollowers(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            Collections.reverse(userResult.getListFollowers());
            return userResult;
        }
        else return null;
    }

    @Override
    public UserResponseListFollowedDTO getUserFollowedList(Integer userId, String order) {
        UserResponseListFollowedDTO userResult = MapperUser.toUserFollowedResponseListDTO(iUserRepository.getUserById(userId));

        if(order== null){
            return userResult;
        }
        else if(order.equals("name_asc")){
            //Sort by Name
            Collections.sort(userResult.getListFollowed(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            return userResult;
        }
        else if(order.equals("name_desc")){
            //Sort by Name
            Collections.sort(userResult.getListFollowed(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            Collections.reverse(userResult.getListFollowed());
            return userResult;
        }
        else return null;

    }

    @Override
    public void Unfollow(Integer userId, Integer userToUnfollow) {

        User customer =  iUserRepository.getUserById(userId);
        System.out.println("holaaaa");
        User seller = iUserRepository.getUserById(userToUnfollow);
        deleteFollower(customer,seller);
        deleteFollowed(customer,seller);
    }
}
