package com.example.demo.project.service;

import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.exception.UsersCantFollowThemselvesException;
import com.example.demo.project.models.User;
import com.example.demo.project.repository.IDataRepository;
import com.example.demo.project.service.dto.SellerDTO;
import com.example.demo.project.service.dto.SellerWithFollowersDTO;
import com.example.demo.project.service.dto.UserDTO;
import com.example.demo.project.service.dto.UserWithFollowingListDTO;
import com.example.demo.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {

    @Autowired
    IDataRepository iDataRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public void follow(int userid, int useridtofollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        if (userid != useridtofollow) {

            User user = iDataRepository.getUserById(userid);
            if (user == null) throw new UserIdNotFoundException(userid);

            User seller = iDataRepository.getUserById(useridtofollow);
            if (seller == null) throw new UserIdNotFoundException(useridtofollow);

            addFollowing(user, useridtofollow);
            addFollower(seller, userid);
            iDataRepository.persistUserDataBase();
        } else {
            throw new UsersCantFollowThemselvesException();
        }
    }

    @Override
    public void unfollow(int userid, int useridtounfollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        if (userid != useridtounfollow) {

            User user = iDataRepository.getUserById(userid);
            if (user == null) throw new UserIdNotFoundException(userid);

            User seller = iDataRepository.getUserById(useridtounfollow);
            if (seller == null) throw new UserIdNotFoundException(useridtounfollow);

            removeFollowing(user, useridtounfollow);
            removeFollower(seller, userid);
            iDataRepository.persistUserDataBase();
        } else {
            throw new UsersCantFollowThemselvesException();
        }
    }

    @Override
    public SellerDTO getFollowerCount(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        return userMapper.toSellerDTO(user);
    }

    @Override
    public SellerDTO getFollowers(int userid, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        List<User> followers = new ArrayList<>();
        for (Integer follower_id: user.getFollowers()) {
            followers.add(iDataRepository.getUserById(follower_id));
        }

        SellerDTO sellerDTO = userMapper.toSellerDTO(user, followers);

        if (order.isPresent()) orderUserDTOList(((SellerWithFollowersDTO)sellerDTO).getFollowers(), order.get());

        return sellerDTO;
    }

    private void orderUserDTOList(List<UserDTO> userDTOList, String order) {
        switch (order) {
            case "name_asc":
                Comparator<UserDTO> userNameComparator = Comparator.comparing(u -> u.getName().toUpperCase());
                userDTOList.sort(userNameComparator);
                break;
            case "name_desc":
                Comparator<UserDTO> userNameComparatorRev = Comparator.comparing(u -> u.getName().toUpperCase());
                userDTOList.sort(userNameComparatorRev.reversed());
                break;
        }
    }

    @Override
    public UserDTO getFollowingCount(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        return userMapper.toUserWithFollowingDTO(user);
    }

    @Override
    public UserDTO getFollowing(int userid, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        List<User> following = new ArrayList<>();
        for (Integer following_id: user.getFollowing()) {
            following.add(iDataRepository.getUserById(following_id));
        }

        UserDTO userDTO = userMapper.toUserWithFollowingDTO(user, following);

        if (order.isPresent()) orderUserDTOList(((UserWithFollowingListDTO)userDTO).getFollowing(), order.get());

        return userDTO;
    }

    public void addFollowing(User user, int userid) {
        if (!user.getFollowing().contains(userid)) {
            user.getFollowing().add(userid);
            user.setFollowing_count(user.getFollowing_count()+1);
        }
    }

    public void removeFollowing(User user, int userid) {
        if (user.getFollowing().contains(userid)) {
            user.getFollowing().remove((Object)userid);
            user.setFollowing_count(user.getFollowing_count()-1);
        }
    }

    public void addFollower(User user, int userid) {
        if (!user.getFollowers().contains(userid)) {
            user.getFollowers().add(userid);
            user.setFollowers_count(user.getFollowers_count()+1);
        }
    }

    public void removeFollower(User user, int userid) {
        if (user.getFollowers().contains(userid)) {
            user.getFollowers().remove((Object)userid);
            user.setFollowers_count(user.getFollowers_count()-1);
        }
    }

}