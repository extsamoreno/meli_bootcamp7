package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.IncorrectOrderTypeException;
import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserAlreadyUnfollowedException;
import com.meli.socialmeli.exception.UserNotFoundException;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.UserDTOFollowedList;
import com.meli.socialmeli.service.dto.UserDTOFollowersCount;
import com.meli.socialmeli.service.dto.UserDTOFollowersList;
import com.meli.socialmeli.service.mapper.UserMapper;
import com.meli.socialmeli.service.util.QuickSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public HttpStatus followUser(int userId, int userIdToFollow) throws UserAlreadyFollowedException, UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId); // Take from the repository the user which is gonna follow someone
        User userToFollow= iUserRepository.getUserById(userIdToFollow); // Take from the repository the user which is gonna be followed
        if (actualUser==null) throw new UserNotFoundException(userId); // If was not found
        if (userToFollow==null) throw new UserNotFoundException(userIdToFollow); // If was not found
        if (actualUser.getFollowed().contains(userToFollow)){ // If the user to be followed is already included in the actualUser's followed list
            throw new UserAlreadyFollowedException(userToFollow);
        } else {
            actualUser.addFollowed(userToFollow); // the user to be followed is added to the actualUser's followed list
            userToFollow.addFollower(actualUser); // the user is added to the userToFollow's follower list
            return HttpStatus.OK;
        }
    }

    @Override
    public UserDTOFollowersCount getFollowersCount(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId); // Take from the repository the user
        if (actualUser==null){ // If the user was not found
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerCount(actualUser); // Take the user, get mapped and return the followers count instead of the original User
    }

    @Override
    public UserDTOFollowersList getFollowersList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId); // Take from the repository the user
        if(actualUser==null){ // If the user was not found
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerList(actualUser); // Take the user, get mapped and return a simple-follower list instead of the original User
    }

    @Override
    public UserDTOFollowedList getFollowedList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId); // Take from the repository the user
        if(actualUser==null){ // If the user was not found
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowedList(actualUser); // Take the user, get mapped and return a simple-followed list instead of the original User
    }

    @Override
    public HttpStatus unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException {
        User actualUser=iUserRepository.getUserById(userId); // Take from the repository the user which is gonna unfollow someone
        User userToUnfollow= iUserRepository.getUserById(userIdToUnfollow); // Take from the repositoru the user which is gonna be unfollowed
        if (actualUser==null) throw new UserNotFoundException(userId); // If was not found
        if (userToUnfollow==null) throw new UserNotFoundException(userIdToUnfollow); // If was not found
        if (!actualUser.getFollowed().contains(userToUnfollow)){ // If the user to be unfollowed is not already included in the actualUser's followed list
            throw new UserAlreadyUnfollowedException(userToUnfollow);
        } else {
            actualUser.getFollowed().remove(userToUnfollow); // the user to be unfollowed is removed from the actualUser's followed list
            userToUnfollow.getFollowers().remove(actualUser); // the user is removed from the userToUnfollow's followers list
            return HttpStatus.OK;
        }
    }

    @Override
    public UserDTOFollowersList getSortedFollowersList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException {
        User actualUser= iUserRepository.getUserById(userId); // Take from the repository the user
        if(actualUser==null){ // If was not found
            throw new UserNotFoundException(userId);
        } else {
            actualUser= new User(actualUser); // Create a new memory address user in order to not modify the original user in the repository
        }
        List<User> sortedUsers=actualUser.getFollowers(); // Take from the user his followers list
        QuickSort sorter= new QuickSort();
        Comparator<String> c=null; // Define a null Comparator
        if (order==null){ // If optional order was not defined
            return getFollowersList(userId); // return the original list
        } else {
            if (order.equals("name_asc")){ // if optional order was defined as asc
                c=QuickSort.string_asc;
            } else if (order.equals("name_des")){ // if optional order was defined as des
                c=QuickSort.string_des;
            } else {
                throw new IncorrectOrderTypeException(order); // If the optional order was neither asc nor des
            }
            if (sortedUsers.size()==0){} // If the user doesn't have any follower
            else { // If the user have 1 or more than 1 follower
                sortedUsers=sortUsers(sortedUsers,c); // Execute the sorting
                actualUser.setFollowers(sortedUsers); // Set the sorter list into the actualUser's follower list
            }
            return UserMapper.toUserFollowerList(actualUser); // Take the user, get mapped and return a simple-follower list instead of the original User
        }
    }

    @Override
    public UserDTOFollowedList getSortedFollowedList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException {
        User actualUser = iUserRepository.getUserById(userId); // Take from the repository the user
        if (actualUser == null) { // If was not found
            throw new UserNotFoundException(userId);
        } else {
            actualUser= new User(actualUser); // Create a new memory address user in order to not modify the original user in the repository
        }
        List<User> sortedUsers = actualUser.getFollowed(); // Take from the user his followed list
        QuickSort sorter = new QuickSort();
        Comparator<String> c = null; // Define a null Comparator
        if (order == null) { // If optional order was not defined
            return getFollowedList(userId); // return the original list
        } else {
            if (order.equals("name_asc")) { // if optional order was defined as asc
                c = QuickSort.string_asc;
            } else if (order.equals("name_des")) { // if optional order was defined as des
                c = QuickSort.string_des;
            } else {
                throw new IncorrectOrderTypeException(order); // If the optional order was neither asc nor des
            }
            if (sortedUsers.size()==0){} // If the user doesn't have any followed
            else { // If the user have 1 or more than 1 followed
                sortedUsers = sortUsers(sortedUsers, c); // Execute the sorting
                actualUser.setFollowed(sortedUsers); // Set the sorter list into the actualUser's followed list
            }
            return UserMapper.toUserFollowedList(actualUser); // Take the user, get mapped and return a simple-followed list instead of the original User
        }
    }

    /**
     * Method that take a List of users and a comparator, sort an array extracted from the list
     * and return a new sorted list
     * @param userList the user list to be sorted
     * @param c the comparator who is going to define the kind of sorting
     * @return the list sorted
     */
    public List<User> sortUsers(List<User> userList, Comparator c){
        User[] arrUserList=userList.toArray(new User[userList.size()]); //Se convierte a arreglo para ordenarlo
        List<User> sortedUserList= new ArrayList<>(); //Aqui se guardaran las fechas ordenadas

        QuickSort sorter= new QuickSort();
        sorter.sortUserByName(arrUserList,c);
        Collections.addAll(sortedUserList,arrUserList); //Ya ordenado se agrega a sortedPostList

        return sortedUserList;
    }
}
