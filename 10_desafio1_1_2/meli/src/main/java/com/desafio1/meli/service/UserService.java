package com.desafio1.meli.service;

import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.model.*;
import com.desafio1.meli.repository.userRepository.IUserrepository;
import com.desafio1.meli.service.DTO.*;
import com.desafio1.meli.service.orderType.UserOrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserrepository iUserrepository;

    /**
     *
     * @param userId
     * @param userIdToFollow
     * @return User userId follow a userIdToFollow
     * @throws NotExistUser
     */
    @Override
    public boolean followUser(Integer userId, Integer userIdToFollow) throws NotExistUser {
        RequestFollowUserToUser requestFollowUserToUser = new RequestFollowUserToUser();

        User user = iUserrepository.findUserById(userId);
        if (user == null)
            throw new NotExistUser(userId);
        requestFollowUserToUser.setUser(user);

        User userFollower = iUserrepository.findUserById(userIdToFollow);
        if (userFollower == null)
            throw new NotExistUser(userIdToFollow);
        requestFollowUserToUser.setUserFollower(userFollower);

        return iUserrepository.follow(requestFollowUserToUser);
    }

    /**
     *
     * @param userId
     * @param userIdToFollow
     * @return User userId UnFollow a User userIdToFollow
     * @throws NotExistUser
     */
    @Override
    public boolean unFollowUser(Integer userId, Integer userIdToFollow) throws NotExistUser{
        RequestUnFollowUserToUser requestUnFollowUserToUser = new RequestUnFollowUserToUser();
        User user = iUserrepository.findUserById(userId);
        if (user == null)
            throw new NotExistUser(userId);
        requestUnFollowUserToUser.setUser(user);

        User userToFollow = iUserrepository.findUserById(userIdToFollow);
        if (userToFollow == null)
            throw new NotExistUser(userIdToFollow);
        requestUnFollowUserToUser.setUserUnFollower(userToFollow);
        return iUserrepository.unFollow(requestUnFollowUserToUser);
    }

    /**
     *
     * @param userId
     * @return Follow count by userId
     * @throws NotExistUser
     */
    @Override
    public ResponseCountFollower countFollowUser (Integer userId) throws NotExistUser{
        User user = iUserrepository.findUserById(userId);
        ResponseCountFollower responseCountFollower = new ResponseCountFollower();
        if (user != null) {
            responseCountFollower.setFollowers_count(iUserrepository.countFollower(userId));
            responseCountFollower.setUserId(user.getId());
            responseCountFollower.setSucessfull(true);
            responseCountFollower.setUserName(user.getName());
        }else {
            throw  new NotExistUser(userId);
        }
        return (responseCountFollower) ;

    }

    /**
     *
     * @param userId
     * @param order
     * @return
     * @throws NotExistUser
     */
    @Override
    public ResponseFollowersListDTO listFollowerUser (Integer userId, UserOrderType order) throws NotExistUser{
        ResponseFollowersListDTO responseFollowersListDTO = new ResponseFollowersListDTO();
        if (iUserrepository.findUserById(userId) != null) {
             try {
                ArrayList<User> userListFollowers = iUserrepository.listFollower(userId).getFollowers();
                sortByName(userListFollowers, order);
                responseFollowersListDTO = iUserrepository.listFollower(userId);
                return (responseFollowersListDTO);
            }catch (Exception x) {
                 throw new NotExistUser(userId);
             }
        }else {
            throw new NotExistUser(userId);
        }

    }

    @Override
    public ResponseFollowsListDTO listFollowUser (Integer userId,UserOrderType order) throws NotExistUser{
        ResponseFollowsListDTO responseFollowListDTO = new ResponseFollowsListDTO();
        if (iUserrepository.findUserById(userId) != null) {
            sortByName(iUserrepository.listFollow(userId).getFollow(), order);
            responseFollowListDTO = iUserrepository.listFollow(userId);
        }
        return (responseFollowListDTO) ;
    }

    private void sortByName(ArrayList<User> list, UserOrderType order) {
        if (order.equals(UserOrderType.name_desc)) sortByNameDesc(list);
        else if (order.equals(UserOrderType.name_asc)) sortByNameAsc(list);
    }

    private void sortByNameAsc(ArrayList<User> list) {
        list.sort(Comparator.comparing(User::getName));
    }

    private void sortByNameDesc(ArrayList<User> list) {
        list.sort(Comparator.comparing(User::getName).reversed());
    }
}
