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
        User actualUser= iUserRepository.getUserById(userId);
        User userToFollow= iUserRepository.getUserById(userIdToFollow);
        if (actualUser==null) throw new UserNotFoundException(userId);
        if (userToFollow==null) throw new UserNotFoundException(userIdToFollow);
        if (actualUser.getFollowed().contains(userToFollow)){
            throw new UserAlreadyFollowedException(userToFollow);
        } else {
            actualUser.addFollowed(userToFollow);
            userToFollow.addFollower(actualUser);
            return HttpStatus.OK;
        }
    }

    @Override
    public UserDTOFollowersCount getFollowersCount(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if (actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerCount(actualUser);
    }

    @Override
    public UserDTOFollowersList getFollowersList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if(actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowerList(actualUser);
    }

    @Override
    public UserDTOFollowedList getFollowedList(int userId) throws UserNotFoundException {
        User actualUser= iUserRepository.getUserById(userId);
        if(actualUser==null){
            throw new UserNotFoundException(userId);
        }
        return UserMapper.toUserFollowedList(actualUser);
    }

    @Override
    public HttpStatus unfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException, UserAlreadyUnfollowedException {
        User actualUser=iUserRepository.getUserById(userId);
        User userToUnfollow= iUserRepository.getUserById(userIdToUnfollow);
        if (actualUser==null) throw new UserNotFoundException(userId);
        if (userToUnfollow==null) throw new UserNotFoundException(userIdToUnfollow);
        if (!actualUser.getFollowed().contains(userToUnfollow)){
            throw new UserAlreadyUnfollowedException(userToUnfollow);
        } else {
            actualUser.getFollowed().remove(userToUnfollow);
            userToUnfollow.getFollowers().remove(actualUser);
            return HttpStatus.OK;
        }
    }

    @Override
    public UserDTOFollowersList getSortedFollowersList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException {
        User actualUser= iUserRepository.getUserById(userId);
        if(actualUser==null){
            throw new UserNotFoundException(userId);
        } else {
            actualUser= new User(actualUser); // Para no modificar el objeto con la direccion de memoria original
        }
        List<User> sortedUsers=actualUser.getFollowers();
        QuickSort sorter= new QuickSort();
        Comparator<String> c=null;
        if (order==null){
            return getFollowersList(userId);
        } else {
            if (order.equals("name_asc")){
                c=QuickSort.string_asc;
            } else if (order.equals("name_des")){
                c=QuickSort.string_des;
            } else {
                throw new IncorrectOrderTypeException(order);
            }
            if (sortedUsers.size()==0){}
            else {
                sortedUsers=sortUsers(sortedUsers,c);
                actualUser.setFollowers(sortedUsers);
            }
            return UserMapper.toUserFollowerList(actualUser);
        }
    }

    @Override
    public UserDTOFollowedList getSortedFollowedList(int userId, String order) throws UserNotFoundException, IncorrectOrderTypeException {
        User actualUser = iUserRepository.getUserById(userId);
        if (actualUser == null) {
            throw new UserNotFoundException(userId);
        } else {
            actualUser= new User(actualUser); // Para no modificar el objeto con la direccion de memoria original
        }
        List<User> sortedUsers = actualUser.getFollowed();
        QuickSort sorter = new QuickSort();
        Comparator<String> c = null;
        if (order == null) {
            return getFollowedList(userId);
        } else {
            if (order.equals("name_asc")) {
                c = QuickSort.string_asc;
            } else if (order.equals("name_des")) {
                c = QuickSort.string_des;
            } else {
                throw new IncorrectOrderTypeException(order);
            }
            if (sortedUsers.size()==0){}
            else {
                sortedUsers = sortUsers(sortedUsers, c);
                actualUser.setFollowed(sortedUsers);
            }
            return UserMapper.toUserFollowedList(actualUser);
        }
    }

    public List<User> sortUsers(List<User> userList, Comparator c){
        User[] arrUserList=userList.toArray(new User[userList.size()]); //Se convierte a arreglo para ordenarlo
        List<User> sortedUserList= new ArrayList<>(); //Aqui se guardaran las fechas ordenadas

        QuickSort sorter= new QuickSort();
        sorter.sortUserByName(arrUserList,c);
        Collections.addAll(sortedUserList,arrUserList); //Ya ordenado se agrega a sortedPostList

        return sortedUserList;
    }
}
