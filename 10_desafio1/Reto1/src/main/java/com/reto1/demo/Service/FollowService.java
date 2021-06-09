package com.reto1.demo.Service;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Exception.UserNotFollowException;
import com.reto1.demo.Model.DTO.Mapper.UserMapper;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.User;
import com.reto1.demo.Model.UserObjets.UserDTOCount;
import com.reto1.demo.Model.UserObjets.UserDTOFolloweds;
import com.reto1.demo.Model.UserObjets.UserDTOFollowers;
import com.reto1.demo.Model.Util.Util;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository iFollowRepository;

    @Override
    public String followOtherUser(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException {
        return iFollowRepository.follow(userId, userIdToFollow);
    }

    @Override
    public UserDTOCount countFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserCount(iFollowRepository.getUserById(userId));
    }

    @Override
    public UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserFollowers(iFollowRepository.getUserById(userId));
    }

    @Override
    public UserDTOFolloweds getFolloweds(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserFolloweds(iFollowRepository.getUserById(userId));
    }

    @Override
    public String creatPost(Post post) throws UserIdNotFoundException, UserNotFollowException {
        User user = iFollowRepository.getUserById(post.getUserId());
        user.addPost(post);
        return post.getDetail().getProductName();
    }

    @Override
    public String unFollow(int userId, int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException {
        return iFollowRepository.unfollow(userId, userIdToUnfollow);
    }

    @Override
    public UserDTOFollowers orderListFollowers(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException {
        UserDTOFollowers followers = getFollowers(userID);
        if(order.equals("name_asc")){
            Util.orderAscByUserName(followers.getFollowers());
        }else if(order.equals("name_desc")){
            Util.orderDescByUserName(followers.getFollowers());
        }else{
            throw new OrderNotFoundException(order, "name");
        }
        return followers;
    }

    @Override
    public UserDTOFolloweds orderListFolloweds(String order, int userID) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException {
        UserDTOFolloweds followeds = getFolloweds(userID);
        if(order.equals("name_asc")){
            Util.orderAscByUserName(followeds.getFollowed());
        }else if(order.equals("name_desc")){
            Util.orderDescByUserName(followeds.getFollowed());
        }else{
            throw new OrderNotFoundException(order, "name");
        }
        return followeds;
    }

}
