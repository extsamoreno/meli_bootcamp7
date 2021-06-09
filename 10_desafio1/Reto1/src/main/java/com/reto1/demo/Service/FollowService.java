package com.reto1.demo.Service;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.Mapper.UserMapper;
import com.reto1.demo.Model.DTO.UserDTOCount;
import com.reto1.demo.Model.DTO.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserDTOFollowers;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public String followOtherUser(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException {
        return iFollowRepository.follow(userId, userIdToFollow);
    }

    @Override
    public UserDTOCount countFollowers(int userId) throws UserIdNotFoundException {
        return UserMapper.toUserDTO(iFollowRepository.getUserById(userId));
    }

    @Override
    public UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException {
        return UserMapper.toUserFollowers(iFollowRepository.getUserById(userId));
    }

    @Override
    public UserDTOFolloweds getFolloweds(int userId) throws UserIdNotFoundException {
        return UserMapper.toUserFolloweds(iFollowRepository.getUserById(userId));
    }

    @Override
    public String creatPost(Post post) throws UserIdNotFoundException {
        User user = iFollowRepository.getUserById(post.getUserId());
        user.addPost(post);
        return post.getDetail().getProductName();
    }

    @Override
    public String unFollow(int userId, int userIdToUnfollow) {
        return null;
    }
}
