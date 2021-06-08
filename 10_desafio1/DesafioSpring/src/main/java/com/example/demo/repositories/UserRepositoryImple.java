package com.example.demo.repositories;

import com.example.demo.dtos.UserFollowedListDTO;
import com.example.demo.dtos.UserFollowerListDTO;
import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.model.User;
import com.example.demo.services.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepositoryImple implements UserRepository{

    private ArrayList<User> usersList = new ArrayList<User>();

    User user1 = new User(1,"User1");
    User user2 = new User(2,"User2");
    User user3 = new User(3,"User3");


    public void addUsers(){
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException {
        User toFollow = null;
        if(!alreadyFollow(userId,userIdToFollow)){

            for(User user:usersList){
                if(user.getUserId()==userIdToFollow){
                    toFollow =user;
                }
            }

            int index = 0;
            for(User user:usersList){
                if(user.getUserId()==userId){
                        usersList.get(index).getFollowed().add(toFollow);
                }
                index++;
            }
        }
    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) {

    }

    @Override
    public UserFollowersCountDTO followersCount(int userId) {
        UserFollowersCountDTO userFollowersCountDTO = null;
        for(User user:usersList){
            if(user.getUserId()==userId){
                userFollowersCountDTO = new UserFollowersCountDTO(userId,user.getUserName(),user.getFollowed().size());
            }
        }
        return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO followersList(int userId) {
        ArrayList<UserResponseDTO> followersList= new ArrayList<>();
        UserFollowerListDTO userFollowerListDTO = null;
        User userFollowed=null;
        for(User user:usersList) {
            if (user.getUserId() == userId) {
                userFollowed = user;
                break;
            }
        }
        for(User user:usersList){
            for(User follower:user.getFollowed()){
                if(follower.getUserId()==userId){
                    followersList.add(new UserResponseDTO(user.getUserId(),user.getUserName()));
                }
                userFollowerListDTO = new UserFollowerListDTO(userFollowed.getUserId(),userFollowed.getUserName(),followersList);
            }
        }

        return userFollowerListDTO;

    }

    @Override
    public UserFollowedListDTO followedList(int userId) {
        ArrayList<UserResponseDTO> followedList= new ArrayList<>();
        UserFollowedListDTO userFollowedListDTO=null;

        for(User user:usersList){
          if(user.getUserId()==userId){
              for(User userf:user.getFollowed()){
                  followedList.add(UserMapper.toDTO(userf));
              }
              userFollowedListDTO = new UserFollowedListDTO(userId,user.getUserName(),followedList);
          }
        }

        return userFollowedListDTO;
    }


    public boolean existUser(int userId){
        boolean exist = false;
        for(User user:usersList){
            if( user.getUserId() == userId){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public boolean alreadyFollow(int userId, int userIdToFollow) throws UserAlreadyFollowException {
       boolean exist=true;

        for(User user:usersList){
            if(user.getUserId()==userId){
                for(User userFollowed:user.getFollowed()){
                    if(userFollowed.getUserId()==userIdToFollow){
                        throw new UserAlreadyFollowException(userId,userIdToFollow);
                    }
                }
            }
        }
        return exist = false;
    }

}
