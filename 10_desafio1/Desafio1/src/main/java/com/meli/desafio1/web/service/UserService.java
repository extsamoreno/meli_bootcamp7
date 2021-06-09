package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.exception.UserAlreadyFollowedException;
import com.meli.desafio1.web.exception.UserException;
import com.meli.desafio1.web.exception.UserNotFoundException;
import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.User;
import com.meli.desafio1.web.repository.IFollowRepository;
import com.meli.desafio1.web.repository.IUserRepository;
import com.meli.desafio1.web.response.CusersResponse;
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
    @Override

    public void follow(int userId, int follow_id) throws UserException {

        Follow user = iFollowRepository.getFollowById(userId);
        Follow followedUser = iFollowRepository.getFollowById(follow_id);
        if(user == null){
            throw new UserNotFoundException(Integer.toString(userId), HttpStatus.BAD_REQUEST);
        }
        else{
            if(followedUser ==null){
                throw new UserNotFoundException(Integer.toString(follow_id), HttpStatus.BAD_REQUEST);
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


    public int unFollow(int userId, int follow_id) {

        System.out.println(iFollowRepository.getFollowList());
        List<Follow> followList = iFollowRepository.getFollowList();
        for (Follow follow : followList) {

            if (follow.getUserId() == userId) {
                List<Integer> followListId = follow.getFollows_id();
                if (followListId.contains(follow_id)) {

                    followListId.remove(Integer.valueOf(follow_id));
                    follow.setFollows_id(followListId);

                    System.out.println(iFollowRepository.getFollowList());
                    return 1;
                }
                else {
                    return 0;
                }

            }

        }
        return -1;
    }


    @Override
    public CusersResponse cUserFollowers(int userId) throws UserNotFoundException{
        int count = 0;
        Follow user = iFollowRepository.getFollowById(userId);
        if(user==null){
            throw new UserNotFoundException(Integer.toString(userId), HttpStatus.BAD_REQUEST);
        }
        List<Follow> follows = iFollowRepository.getFollowList();
        for(Follow follow:follows){
            if(follow.getFollows_id().contains(userId)){
                count++;
            }
        }

        return new CusersResponse(userId,userNameByUserId(userId),count);
    }



    @Override
    public String userNameByUserId(int userId) {
        List<User> userList = iUserRepository.getUserList();
        for(User user:userList){
            if(user.getUserId()==userId){
                return user.getUserName();
            }
        }
        return "";
    }
    @Override
    public void orderUserDTO(List<UserDTO> userDTOS, String order){
        System.out.println("ingreso a order");
        Collections.sort(userDTOS, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });
        System.out.println("luego de sort");
        if(order.equals("name_desc")){
            Collections.reverse(userDTOS);
        }
    }

    @Override
    public List<UserDTO> followersByUserId(int userId, String order) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = iUserRepository.getUserList();
        List<Follow> follows = iFollowRepository.getFollowList();
        for(Follow follow:follows){
            if(follow.getFollows_id().contains(userId)){
                userDTOS.add(new UserDTO(follow.getUserId(),userNameByUserId(follow.getUserId())));
            }
        }

        if(order.equals("name_asc") || order.equals("name_desc")){
            orderUserDTO(userDTOS,order);
        }


        return userDTOS;
    }

    @Override
    public List<UserDTO> followedByUserId(int userId, String order) {
        List<Follow> followList = iFollowRepository.getFollowList();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(Follow follow:followList){
            if(follow.getUserId()==userId){
                for(int followed:follow.getFollows_id()){
                    userDTOS.add(new UserDTO(followed,userNameByUserId(followed)));
                }
            }
        }

        if(order.equals("name_asc") || order.equals("name_desc")) {
            orderUserDTO(userDTOS, order);
        }
        return userDTOS;
    }




}
