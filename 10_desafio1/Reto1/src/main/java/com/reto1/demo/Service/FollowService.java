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
import com.reto1.demo.Model.Util.Util;
import com.reto1.demo.Repository.IFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowService implements IFollowService{

    @Autowired
    IFollowRepository iFollowRepository;

    /**
     *
     * @param userId
     * @param userIdToFollow
     * @return
     * @throws UserAlreadyFollowException
     * @throws UserIdNotFoundException
     *
     * Follow other user
     */
    @Override
    public String followOtherUser(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserIdNotFoundException, SameIdException {
        if(userId == userIdToFollow) throw new SameIdException();
        return iFollowRepository.follow(userId, userIdToFollow);
    }

    /**
     *
     * @param userId
     * @return userDTOCount
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     *
     * Return user with count followers
     */
    @Override
    public UserDTOCount countFollowers(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserCount(iFollowRepository.getUserById(userId));
    }

    /**
     *
     * @param userId
     * @return UserDTOFollowers (List followers)
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
     *
     * @param userId
     * @return UserDTOFolloweds(List pages followed)
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     */
    @Override
    public UserDTOFolloweds getFolloweds(int userId) throws UserIdNotFoundException, UserNotFollowException {
        return UserMapper.toUserFolloweds(iFollowRepository.getUserById(userId));
    }

    /**
     *
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
     *
     * @param order
     * @param userID
     * @return UserDTOFollowers order default asc
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
     *
     * @param order
     * @param userID
     * @return UserDTOFolloweds order default asc
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
}
