package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.FollowNotFoundUserException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.exception.InvalidUserNameException;
import com.meli.SocialMeli.exception.RepeatedFollowUserException;
import com.meli.SocialMeli.model.Follow;
import com.meli.SocialMeli.repository.IUserRepository;
import com.meli.SocialMeli.mapper.UserMapper;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void newUser(UserNewDto userNewDto) throws InvalidUserNameException {
        validateNewUser(userNewDto);
        User newUser=UserMapper.userNewDtotoUser(userNewDto);
        iUserRepository.newUser(newUser);
    }

    @Override
    public void follow(int followerId, int followedId) throws InvalidUserIdException, RepeatedFollowUserException {
        Follow follow = new Follow(-1, followerId,followedId);
        validateFollow(follow);
        iUserRepository.follow(follow);
    }

    @Override
    public UserFollowerCountDto followerCount(int id) throws InvalidUserIdException {
        validateId(id);
        UserFollowerCountDto userDto = UserMapper.userToUserFollowerCDto(iUserRepository.getUserById(id));
        userDto.setFollowers_count(iUserRepository.getFollowers(id).size());
        return userDto;
    }

    @Override
    public UserFollowerListDto followerList(int id, Optional<String> order) throws InvalidUserIdException {
        validateId(id);
        UserFollowerListDto userDto = UserMapper.userToUserFollowerLDto(iUserRepository.getUserById(id));
        ArrayList<User> userList = iUserRepository.getFollowers(id);
        if(order.isEmpty()) order=Optional.of("aa");
        userList=sortUser(userList,order.get());
        userDto.setFollowers(UserMapper.batchUserToBasicDto(userList));
        return userDto;
    }

    @Override
    public UserFollowedListDto followedList(int id, Optional<String> order) throws InvalidUserIdException {
        validateId(id);
        UserFollowedListDto userDto = UserMapper.userToUserFollowedLDto(iUserRepository.getUserById(id));
        ArrayList<User> userList = iUserRepository.getFolloweds(id);
        if(order.isEmpty()) order=Optional.of("aa");
        userList=sortUser(userList,order.get());
        userDto.setFolloweds(UserMapper.batchUserToBasicDto(userList));
        return userDto;
    }

    @Override
    public void unfollow(int followerId, int followedId) throws FollowNotFoundUserException {
        Follow follow=iUserRepository.getFollow(followerId,followedId);
        if(follow!=null){
            follow.setActive(false);
            iUserRepository.editFollow(follow);
        }else throw new FollowNotFoundUserException();
    }

    private void validateNewUser(UserNewDto userNewDto) throws InvalidUserNameException {
        if(userNewDto.getUserName().equals("")) throw new InvalidUserNameException();
    }

    private void validateId(int id) throws InvalidUserIdException {
        if(iUserRepository.getUserById(id)==null){
            throw new InvalidUserIdException();
        }
    }

    private void validateFollow(Follow follow) throws InvalidUserIdException, RepeatedFollowUserException {
        if(follow.getFollowerId()== follow.getFollowedId()){
            throw new InvalidUserIdException();
        }
        validateId(follow.getFollowerId());
        validateId(follow.getFollowedId());
        System.out.println(iUserRepository.getFollow(follow.getFollowerId(),follow.getFollowedId()));
        if(iUserRepository.getFollow(follow.getFollowerId(),follow.getFollowedId())!=null){
            throw new RepeatedFollowUserException();
        }
    }

    private ArrayList<User> sortUser(ArrayList<User> userList, String order) {
        Comparator<User> comp;
        switch(order){
            case "name_asc":
                comp = (a,b)->a.getUserName().compareTo(b.getUserName());
                break;
            case "name_desc":
                comp = (a,b)->b.getUserName().compareTo(a.getUserName());
                break;
            default:
                return userList;
        }
        userList=new SortUtil<User>().sort(userList,comp);
        return userList;
    }

    private ArrayList<Integer> extractFollowers(ArrayList<Follow> follows){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Follow follow : follows) {
            idList.add(follow.getFollowerId());
        }
        return idList;
    }

    private ArrayList<Integer> extractFolloweds(ArrayList<Follow> follows){
        ArrayList<Integer> idList = new ArrayList<>();
        for (Follow follow : follows) {
            idList.add(follow.getFollowedId());
        }
        return idList;
    }
}
