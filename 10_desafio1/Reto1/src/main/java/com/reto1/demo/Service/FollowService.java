package com.reto1.demo.Service;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.UserException.SameIdException;
import com.reto1.demo.Exception.UserException.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.DTO.Mapper.UserMapper;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOCount;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFolloweds;
import com.reto1.demo.Model.DTO.UserObjets.UserDTOFollowers;
import com.reto1.demo.Model.DTO.UserObjets.UserRequest;
import com.reto1.demo.Model.Util.Util;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository iFollowRepository;

    /**
     * Follow other user
     * @param userId
     * @param userIdToFollow
     * @return
     * @throws UserAlreadyFollowException
     * @throws UserIdNotFoundException
     *
     *
     */
    @Override
    public String followOtherUser(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException, SameIdException {
        if(userId == userIdToFollow) throw new SameIdException();
        return iFollowRepository.follow(userId, userIdToFollow);
    }

    /**
     * User with count followers
     * @param userId
     * @return userDTOCount
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     *
     *
     */
    @Override
    public UserDTOCount countFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserCount(iFollowRepository.getUserById(userId));
    }

    /**
     * List followers
     * @param userId
     * @return UserDTOFollowers
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     *
     *
     */
    @Override
    public UserDTOFollowers getFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserFollowers(iFollowRepository.getUserById(userId));
    }

    /**
     * List pages followed
     * @param userId
     * @return UserDTOFolloweds
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     */
    @Override
    public UserDTOFolloweds getFolloweds(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserFolloweds(iFollowRepository.getUserById(userId));
    }

    /**
     * UnFollow user
     * @param userId
     * @param userIdToUnfollow
     * @return String name unFollow user
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     */
    @Override
    public String unFollow(int userId, int userIdToUnfollow) throws UserNotFollowException, UserIdNotFoundException {
        return iFollowRepository.unfollow(userId, userIdToUnfollow);
    }

    /**
     * List followers Order default asc
     * @param order
     * @param userID
     * @return UserDTOFollowers
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     * @throws OrderNotFoundException
     */
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

    /**
     * List users followed Order default asc
     * @param order
     * @param userID
     * @return UserDTOFolloweds
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     * @throws OrderNotFoundException
     */
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

    /**
     * Create User
     * @param user
     * @return String name new user
     */
    @Override
    public int createUser(UserRequest user) {
        return iFollowRepository.createUser(user);
    }
}
