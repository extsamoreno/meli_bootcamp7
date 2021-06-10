package com.example.Challenge.service;

import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.exception.ProgramException;
import com.example.Challenge.exception.UserIdNotFoundException;
import com.example.Challenge.mapper.MapperUser;
import com.example.Challenge.model.User;
import com.example.Challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserServiceImpl implements   IUserService{

    @Autowired
    IUserRepository iUserRepository;

    public void addFollower(User customer, User seller) {
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
    public void Follow(Integer userId, Integer userToFollow) throws ProgramException {

        User customer =  iUserRepository.getUserById(userId);
        User seller = iUserRepository.getUserById(userToFollow);

        //Exceptions
        if(customer == null) throw new UserIdNotFoundException(userId);
        else if (seller == null) throw new UserIdNotFoundException(userToFollow);
        else if(customer.getFollowed().contains(MapperUser.toUserDTO(seller))){
            throw new ProgramException("You already follow the seller", HttpStatus.BAD_REQUEST);
        }else if(userId.equals(userToFollow)){
            throw new ProgramException("You can't follow yourself", HttpStatus.BAD_REQUEST);
        }else if(!seller.isSeller()){
            throw new ProgramException("You can only follow sellers", HttpStatus.BAD_REQUEST);
        }

        addFollower(customer,seller);
        addFollowed(customer,seller);

    }

    @Override
    public UserResponseCountDTO getUserFollowersCount(Integer userId) throws ProgramException {
        User user = iUserRepository.getUserById(userId);

        if(user == null) throw new UserIdNotFoundException(userId);
        else if(!user.isSeller()) throw new ProgramException("Only sellers have followers", HttpStatus.BAD_REQUEST);

        UserResponseCountDTO userResult = MapperUser.toUserResponseCountDTO(user);
        return userResult;
    }

    @Override
    public UserResponseListDTO getUserFollowersList(Integer userId, String order) throws ProgramException {

        User user = iUserRepository.getUserById(userId);
        //Exceptions
        if(user == null) throw new UserIdNotFoundException(userId);
        else if(!user.isSeller()) throw new ProgramException("Only sellers have followers", HttpStatus.BAD_REQUEST);

        UserResponseListDTO userResult = MapperUser.toUserResponseListDTO(user);
        if(order== null){
            return userResult;
        }
        else if(order.equals("name_asc")){
            //Sort by Name asc
            Collections.sort(userResult.getListFollowers(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            return userResult;
        }
        else if(order.equals("name_desc")){
            //Sort by Name desc
            Collections.sort(userResult.getListFollowers(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            Collections.reverse(userResult.getListFollowers());
            return userResult;
        }
        else return null;
    }

    @Override
    public UserResponseListFollowedDTO getUserFollowedList(Integer userId, String order) throws ProgramException {
        User user = iUserRepository.getUserById(userId);
        //Exceptions
        if(user == null) throw new UserIdNotFoundException(userId);

        UserResponseListFollowedDTO userResult = MapperUser.toUserFollowedResponseListDTO(user);

        if(order== null){
            return userResult;
        }
        else if(order.equals("name_asc")){
            //Sort by Name asc
            Collections.sort(userResult.getListFollowed(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            return userResult;
        }
        else if(order.equals("name_desc")){
            //Sort by Name desc
            Collections.sort(userResult.getListFollowed(), (o1, o2) ->o1.getUserName().compareTo(o2.getUserName()) );
            Collections.reverse(userResult.getListFollowed());
            return userResult;
        }
        else return null;

    }

    @Override
    public void Unfollow(Integer userId, Integer userToUnfollow) throws ProgramException {

        User customer =  iUserRepository.getUserById(userId);
        User seller = iUserRepository.getUserById(userToUnfollow);
        //Exceptions
        if(customer == null) throw new UserIdNotFoundException(userId);
        else if (seller == null) throw new UserIdNotFoundException(userToUnfollow);
        else if(!customer.getFollowed().contains(MapperUser.toUserDTO(seller))){
            throw new ProgramException("you don't follow that user", HttpStatus.BAD_REQUEST);
        }else if(userId.equals(userToUnfollow)){
            throw new ProgramException("You can't unfollow yourself", HttpStatus.BAD_REQUEST);
        }else if(!seller.isSeller()){
            throw new ProgramException("You can only unfollow sellers", HttpStatus.BAD_REQUEST);
        }

        deleteFollower(customer,seller);
        deleteFollowed(customer,seller);
    }
}
