package com.desafio1.meli.repository.userRepository;

import com.desafio1.meli.model.*;
import com.desafio1.meli.service.DTO.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class UserRepositoy implements IUserrepository {

    private List<User> users ;
    private HashMap<Integer, ArrayList<User>> follow;
    private HashMap<Integer, ArrayList<User>> follower;


    public UserRepositoy() {

        this.users = loadDatabase();
        this.follow = new HashMap<>();
        this.follower = new HashMap<>();
    }

    @Override
    public boolean follow(RequestFollowUserToUser requestFollowUserToUser){
        try{
            // If follow list is empty
            if (this.follow.isEmpty()){
                ArrayList<User> userList = new ArrayList<>();
                userList.add(findUserById(requestFollowUserToUser.getUserFollower().getId()));
                this.follow.put(requestFollowUserToUser.getUser().getId(), userList);
            }else{
                if (!this.follow.containsKey(requestFollowUserToUser.getUser().getId())){
                    ArrayList<User> userList = new ArrayList<>();
                    userList.add(findUserById(requestFollowUserToUser.getUserFollower().getId()));
                    this.follower.put(requestFollowUserToUser.getUser().getId(), userList);
                }else {
                    User getUser = findUserById(requestFollowUserToUser.getUserFollower().getId());
                    this.follow.get(requestFollowUserToUser.getUser().getId()).add(getUser);
                }

            }
            // If follower list is empty
            if (this.follower.isEmpty()){
                ArrayList<User> userList = new ArrayList<>();
                //Agrego al Arreglo user el user que sigue
                userList.add(findUserById(requestFollowUserToUser.getUser().getId()));
                // en el key-> seguido agrego el usuario que sigue al seguido
                this.follower.put(requestFollowUserToUser.getUserFollower().getId(), userList);
            }else{
                // Si en la key seguido no tiene a nadie se crea el array y se asigna
                if(!this.follower.containsKey(requestFollowUserToUser.getUserFollower().getId())){
                    ArrayList<User> userList = new ArrayList<>();
                    userList.add(findUserById(requestFollowUserToUser.getUser().getId()));
                    this.follower.put(requestFollowUserToUser.getUserFollower().getId(), userList);
                }else{
                    //sino se asigna en el key del seguido
                    User getUser = findUserById(requestFollowUserToUser.getUser().getId());
                    this.follower.get(requestFollowUserToUser.getUserFollower().getId()).add(getUser);
                }

            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Override
    public boolean unFollow(RequestUnFollowUserToUser requestUnFollowUserToUser){
        boolean status = false;
        try{
            // If follow list is !empty
            if (!this.follow.isEmpty() && findUserById(requestUnFollowUserToUser.getUserUnFollower().getId())!=null){
                User user = findUserById(requestUnFollowUserToUser.getUserUnFollower().getId());
                status =  this.follow.get(requestUnFollowUserToUser.getUser().getId()).remove(user);
            }
            // If follower list is !empty
            if (!this.follower.isEmpty() && findUserById(requestUnFollowUserToUser.getUser().getId())!=null){
                User user = findUserById(requestUnFollowUserToUser.getUser().getId());
                status = this.follower.get(requestUnFollowUserToUser.getUserUnFollower().getId()).remove(user);;
            }
            return status;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Integer countFollower(Integer userId){
        try{
            return  this.follower.get(userId).size();
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public ResponseFollowersListDTO listFollower(Integer userId){
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        try{
            responseFollowersListDTO.setFollowers(this.follower.get(userId));
            responseFollowersListDTO.setUserName(findUserById(userId).getName());
            responseFollowersListDTO.setUserId(userId);
        }catch (Exception e){
            System.out.println("falla");
        }
        return responseFollowersListDTO;
    }

    @Override
    public ResponseFollowsListDTO listFollow(Integer userId){
        ResponseFollowsListDTO responseFollowListDTO = new ResponseFollowsListDTO();
        try{
            responseFollowListDTO.setFollow(this.follow.get(userId));
            responseFollowListDTO.setUserName(findUserById(userId).getName());
            responseFollowListDTO.setUserId(userId);
        }catch (Exception e){
            System.out.println("falla");
        }
        return responseFollowListDTO;
    }



    @Override
    public User findUserById(Integer id){
        User user = null;
        for (User loadUser : this.users) {
            if (loadUser.getId().equals(id)){
                user = loadUser;
            }
        }
        return user;
    }

    private List<User> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
