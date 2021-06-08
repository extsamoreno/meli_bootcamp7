package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.User;
import com.meli.desafio1.web.repository.IFollowRepository;
import com.meli.desafio1.web.repository.IUserRepository;
import com.meli.desafio1.web.response.CusersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IFollowRepository iFollowRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Override

    public int follow(int userId, int follow_id) {

        System.out.println(iFollowRepository.getFollowList());
        List<Follow> followList = iFollowRepository.getFollowList();

        System.out.println(followList.size());
        for (Follow follow : followList) {
            System.out.println("Entró a for");
            if (follow.getUserId() == userId) {
                List<Integer> followListId = follow.getFollows_id();
                if (!followListId.contains(follow_id)) {

                    followListId.add(follow_id);
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
    public CusersResponse cUserFollowers(int userId) {
        int count = 0;
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
    public List<UserDTO> followersByUserId(int userId) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = iUserRepository.getUserList();
        List<Follow> follows = iFollowRepository.getFollowList();
        for(Follow follow:follows){
            if(follow.getFollows_id().contains(userId)){
                userDTOS.add(new UserDTO(follow.getUserId(),userNameByUserId(follow.getUserId())));
            }
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> followedByUserId(int userId) {
        List<Follow> followList = iFollowRepository.getFollowList();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(Follow follow:followList){
            if(follow.getUserId()==userId){
                for(int followed:follow.getFollows_id()){
                    userDTOS.add(new UserDTO(followed,userNameByUserId(followed)));
                }
            }
        }
        return userDTOS;
    }


}
