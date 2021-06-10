package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Seller;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements iUserService {

    @Autowired
    IUserRepository repository;
    @Autowired
    iSocialMeliMapper mapper;

    /**
     * 0001 - Follows certain seller
     * @param userId
     * @param userIdToFollow
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public Void follow (Integer userId, Integer userIdToFollow) throws UserNotFoundException, AlreadyFollowingException {
        User user = repository.findUserById(userId);
        Seller userToFollow = repository.findSellerById(userIdToFollow);

        if (!user.getFollowing().stream().filter(seller -> seller.getUsername().equals(userToFollow.getUsername())).collect(Collectors.toList()).isEmpty())
            throw new AlreadyFollowingException(user.getUsername());

        user.getFollowing().add(userToFollow);
        return null;
    }

    /**
     *0002 - Gets the amount of users that follows a certain seller
     * @param userId
     * @return FollowersCountDTO--> int userId, string username, int followersCount
     * @throws UserNotFoundException
     */
    @Override
    public FollowersCountDTO countFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(userId);
        return (new FollowersCountDTO(userId, seller.getUsername(), seller.getFollowers().size()));
    }

    /**
     * 0003 - Gets a list of the users that follow a certain seller
     * @param userId
     * @return FollowListDTO--> int userId, string username, arrayList<UserDTO> followList;
     * @throws UserNotFoundException
     */
    @Override
    public FollowListDTO listFollowers (Integer userId) throws UserNotFoundException {
        Seller seller = repository.findSellerById(userId);
        return (new FollowListDTO(userId, seller.getUsername(), seller.getFollowers()));
    }

    /**
     * 0004 - Gets a list of the sellers followed by a certain user
     * @param userId
     * @return FollowListDTO--> int userId, string username, arrayList<UserDTO> followList;
     * @throws UserNotFoundException
     */
    @Override
    public FollowListDTO listFollowed (Integer userId) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        return (new FollowListDTO(userId, user.getUsername(), mapper.mapSellerToUserDTOList(user.getFollowing())));
    }

    /**
     *
     * @param userId
     * @param userIdToUnfollow
     * @return
     * @throws UserNotFoundException
     * @throws NotFollowingException
     */
    @Override
    public Void unfollow (Integer userId, Integer userIdToUnfollow) throws UserNotFoundException, NotFollowingException {
        User user = repository.findUserById(userId);
        Seller userToUnfollow = repository.findSellerById(userIdToUnfollow);

        if (user.getFollowing().stream().filter(seller -> seller.getUsername().equals(userToUnfollow.getUsername())).collect(Collectors.toList()).isEmpty())
            throw new NotFollowingException(user.getUsername());
        user.getFollowing().remove(userToUnfollow);

        return null;
    }

    /**
     * 0008 - Orders followers by name (asc or desc)
     * @param sellerId
     * @param order
     * @return ArrayList<UserDTO> (UserDto--> int userId, string username)
     * @throws UserNotFoundException
     * @throws WrongCriteriaOrderException
     */
    @Override
    public ArrayList<UserDTO> orderFollowersByName(Integer sellerId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        Seller seller = repository.findSellerById(sellerId);

        switch (order){
            case "name_asc":
                Collections.sort(seller.getFollowers());
                break;
            case "name_desc":
                Collections.sort(seller.getFollowers(), Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return seller.getFollowers();
    }

    /**
     * 0008 - Orders followed by name (asc or desc)
     * @param userId
     * @param order
     * @return ArrayList<Seller>
     * @throws UserNotFoundException
     * @throws WrongCriteriaOrderException
     */
    @Override
    public ArrayList<Seller> orderFollowedByName(Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException {
        User user = repository.findUserById(userId);

        switch (order){
            case "name_asc":
                Collections.sort(user.getFollowing());
                break;
            case "name_desc":
                Collections.sort(user.getFollowing(), Collections.reverseOrder());
                break;
            default:
                throw new WrongCriteriaOrderException();
        }
        return user.getFollowing();
    }
}