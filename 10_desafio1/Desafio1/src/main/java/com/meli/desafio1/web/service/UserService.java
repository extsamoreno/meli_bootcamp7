package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.*;
import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.User;
import com.meli.desafio1.web.repository.IFollowRepository;
import com.meli.desafio1.web.repository.IUserRepository;
import com.meli.desafio1.web.response.CusersResponse;
import com.meli.desafio1.web.response.FollowedListResponse;
import com.meli.desafio1.web.response.FollowersListResponse;
import com.meli.desafio1.web.response.PostListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IFollowRepository iFollowRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IUserService iUserService;

    @Override

    public void follow(int userId, int follow_id) throws UserException {

        Follow user = iFollowRepository.getFollowById(userId);
        Follow followedUser = iFollowRepository.getFollowById(follow_id);
        if(userId == follow_id){
            throw new FollowActionInvalidException(userId,HttpStatus.BAD_REQUEST);
        }
        if(user == null){
            throw new UserNotFoundException(userId, HttpStatus.BAD_REQUEST);
        }
        else{
            if(followedUser ==null){
                throw new UserNotFoundException(follow_id, HttpStatus.BAD_REQUEST);
            }
        }
        List<Integer> followListId = user.getFollows_id();
        if(!user.getFollows_id().contains(follow_id)){
            followListId.add(follow_id);
            user.setFollows_id(followListId);

        }
        else {
            throw new UserAlreadyFollowedException(userId,follow_id, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void unFollow(int userId, int follow_id) throws UserException{
        Follow user = iFollowRepository.getFollowById(userId);
        Follow followedUser = iFollowRepository.getFollowById(follow_id);
        List<Integer> followListId = user.getFollows_id();
        System.out.println(user);
        if(user==null){
            throw new UserNotFoundException(userId,HttpStatus.BAD_REQUEST);
        }
        else {
            if (followedUser == null) {
                throw new UserNotFoundException(follow_id, HttpStatus.BAD_REQUEST);
            }
        }
        if (followListId.contains(follow_id)) {

                followListId.remove(Integer.valueOf(follow_id));
                user.setFollows_id(followListId);
            }
        else{
            throw new UserNotFollowedException(userId,follow_id,HttpStatus.BAD_REQUEST);
        }


    }


    @Override
    public CusersResponse cUserFollowers(int userId) throws UserNotFoundException{
        int count = 0;
        Follow user = iFollowRepository.getFollowById(userId);
        if(user==null){
            throw new UserNotFoundException(userId, HttpStatus.BAD_REQUEST);
        }
        List<Follow> follows = iFollowRepository.getFollowList();
        for(Follow follow:follows){
            if(follow.getFollows_id().contains(userId)){
                count++;
            }
        }

        return new CusersResponse(userId,iUserRepository.userNameByUserId(userId),count);
    }





    @Override
    public void orderUserDTO(List<UserDTO> userDTOS, String order){

        Collections.sort(userDTOS, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });

        if(order.equals("name_desc")){
            Collections.reverse(userDTOS);
        }
    }

    @Override
    public FollowersListResponse followersByUserId(int userId, String order) throws UserException{
        User user = iUserRepository.getUserById(userId);
        if(user == null){
            throw new UserNotFoundException(userId,HttpStatus.BAD_REQUEST);
        }

        if(!order.equals("") && !order.equals("name_desc") && !order.equals("name_asc")){
            throw new UserOrderNotValidException(order,HttpStatus.BAD_REQUEST);
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = iUserRepository.getUserList();
        List<Follow> follows = iFollowRepository.getFollowList();
        for(Follow follow:follows){
            if(follow.getFollows_id().contains(userId)){
                userDTOS.add(new UserDTO(follow.getUserId(), iUserRepository.userNameByUserId(follow.getUserId())));
            }
        }

        if(order.equals("name_asc") || order.equals("name_desc")){
            orderUserDTO(userDTOS,order);
        }


        return new FollowersListResponse(userId,iUserRepository.userNameByUserId(userId),userDTOS);
    }

    @Override
    public FollowedListResponse followedByUserId(int userId, String order) throws UserException {
        Follow user = iFollowRepository.getFollowById(userId);
        if(user == null){
            throw new UserNotFoundException(userId,HttpStatus.BAD_REQUEST);
        }
        if(!order.equals("") && !order.equals("name_desc") && !order.equals("name_asc")){
            throw new UserOrderNotValidException(order,HttpStatus.BAD_REQUEST);
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        for(int followed:user.getFollows_id()){
            userDTOS.add(new UserDTO(followed,iUserRepository.userNameByUserId(followed)));
        }

        if(order.equals("name_asc") || order.equals("name_desc")) {
            orderUserDTO(userDTOS, order);
        }
        return new FollowedListResponse(userId,iUserRepository.userNameByUserId(userId),userDTOS);
    }






}
