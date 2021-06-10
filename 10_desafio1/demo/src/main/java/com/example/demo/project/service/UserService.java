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
    public void follow(int user_id, int user_id_to_follow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        if (user_id != user_id_to_follow) {

            User user = iDataRepository.getUserById(user_id);
            if (user == null) throw new UserIdNotFoundException(user_id);

            User seller = iDataRepository.getUserById(user_id_to_follow);
            if (seller == null) throw new UserIdNotFoundException(user_id_to_follow);

            addFollowing(user, user_id_to_follow);
            addFollower(seller, user_id);
            iDataRepository.persistUserDataBase();
        } else {
            throw new UsersCantFollowThemselvesException();
        }
    }

    @Override
    public void unfollow(int user_id, int user_id_to_unfollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        if (user_id != user_id_to_unfollow) {

            User user = iDataRepository.getUserById(user_id);
            if (user == null) throw new UserIdNotFoundException(user_id);

            User seller = iDataRepository.getUserById(user_id_to_unfollow);
            if (seller == null) throw new UserIdNotFoundException(user_id_to_unfollow);

            removeFollowing(user, user_id_to_unfollow);
            removeFollower(seller, user_id);
            iDataRepository.persistUserDataBase();
        } else {
            throw new UsersCantFollowThemselvesException();
        }
    }

    @Override
    public SellerDTO getFollowerCount(int user_id) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(user_id);
        return userMapper.toSellerDTO(user);
    }

    @Override
    public SellerDTO getFollowers(int user_id, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(user_id);
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
    public UserDTO getFollowingCount(int user_id) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(user_id);
        return userMapper.toUserWithFollowingDTO(user);
    }

    @Override
    public UserDTO getFollowing(int user_id, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(user_id);
        List<User> following = new ArrayList<>();
        for (Integer following_id: user.getFollowed()) {
            following.add(iDataRepository.getUserById(following_id));
        }

        UserDTO userDTO = userMapper.toUserWithFollowingDTO(user, following);

        if (order.isPresent()) orderUserDTOList(((UserWithFollowingListDTO)userDTO).getFollowed(), order.get());

        return userDTO;
    }

    public void addFollowing(User user, int user_id) {
        if (!user.getFollowed().contains(user_id)) {
            user.getFollowed().add(user_id);
            user.setFollowed_count(user.getFollowed_count()+1);
        }
    }

    public void removeFollowing(User user, int user_id) {
        if (user.getFollowed().contains(user_id)) {
            user.getFollowed().remove((Object)user_id);
            user.setFollowed_count(user.getFollowed_count()-1);
        }
    }

    public void addFollower(User user, int user_id) {
        if (!user.getFollowers().contains(user_id)) {
            user.getFollowers().add(user_id);
            user.setFollowers_count(user.getFollowers_count()+1);
        }
    }

    public void removeFollower(User user, int user_id) {
        if (user.getFollowers().contains(user_id)) {
            user.getFollowers().remove((Object)user_id);
            user.setFollowers_count(user.getFollowers_count()-1);
        }
    }

}