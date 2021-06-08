package com.example.demo.project.service;

import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.exception.UsersCantFollowThemselvesException;
import com.example.demo.project.models.User;
import com.example.demo.project.repository.IDataRepository;
import com.example.demo.project.service.dto.SellerDTO;
import com.example.demo.project.service.dto.UserDTO;
import com.example.demo.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            user.addFollowing(useridtofollow);
            seller.addFollower(userid);
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
    public SellerDTO getFollowers(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        List<User> followers = new ArrayList<>();
        for (Integer follower_id: user.getFollowers()) {
            followers.add(iDataRepository.getUserById(follower_id));
        }
        return userMapper.toSellerDTO(user, followers);
    }

    @Override
    public UserDTO getFollowingCount(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        return userMapper.toUserWithFollowingDTO(user);
    }

    @Override
    public UserDTO getFollowing(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        List<User> following = new ArrayList<>();
        for (Integer following_id: user.getFollowing()) {
            following.add(iDataRepository.getUserById(following_id));
        }
        return userMapper.toUserWithFollowingDTO(user, following);
    }



    /*
    @Override
    public Integer addUrlToRepository(UrlDTO urldto) throws UrlNotValidException{
        UrlValidator urlValidator = new UrlValidator(SCHEME);
        if (urlValidator.isValid(urldto.getUrl())) {
            Url url = UrlMapper.toUrl(urldto);
            return iUrlRepository.addUrl(url);
        } else {
            throw new UrlNotValidException(urldto.getUrl());
        }
    }

    @Override
    public UrlDTO getUrlById(Integer id) throws UrlIdNotFoundException {
        Url url = iUrlRepository.getById(id);
        return UrlMapper.toDTO(url);
    }*/

}