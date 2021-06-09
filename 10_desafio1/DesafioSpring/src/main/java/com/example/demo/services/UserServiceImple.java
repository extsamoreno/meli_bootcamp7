package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repositories.CategoryRepositoryImple;
import com.example.demo.repositories.ProductRepositoryImple;
import com.example.demo.repositories.UserRepositoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepositoryImple userRepositoryImple;
    @Autowired
    ProductRepositoryImple productRepositoryImple;
    @Autowired
    CategoryRepositoryImple categoryRepositoryImple;

    @Override
    public void addUsers() {
        userRepositoryImple.addUsers();
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDoesntExistException {
            userRepositoryImple.follow(userId,userIdToFollow);
    }

    @Override
    public void unfollow(int userId, int userIdToFollow) {
        if(userRepositoryImple.existUser(userId) && userRepositoryImple.existUser(userIdToFollow)){
            userRepositoryImple.unfollow(userId,userIdToFollow);
        }
    }


    @Override
    public UserFollowersCountDTO getFollowersCount(int userId) throws UserDoesntExistException {
        UserFollowersCountDTO userFollowersCountDTO =  userRepositoryImple.getFollowersCount(userId);
       return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO getFollowersList(int userId,String order) throws UserDoesntExistException {
        UserFollowerListDTO  userFollowerListDTO = userRepositoryImple.getFollowersList(userId, order);
        return userFollowerListDTO;
    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId, String order) throws UserDoesntExistException {
        UserFollowedListDTO userFollowedListDTO =  userRepositoryImple.getFollowedList(userId,order);
        return userFollowedListDTO;
    }

    /*@Override
    public NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO) throws ParseException {
        NewPostResponseDTO newPostResponseDTO=null;
            User user = userRepositoryImple.findUserById(newPostRequestDTO.getUserId());
            Product product = productRepositoryImple.findProductById(newPostRequestDTO.getDetail().getProduct_id());
            Category category = categoryRepositoryImple.findCategoryById(newPostRequestDTO.getCategory());

            if(user != null && product != null && category!=null){
                newPostResponseDTO = userRepositoryImple.newPost(newPostRequestDTO,category);
            }

        return newPostResponseDTO;
    }
    */
   /* @Override
    public FollowedPostListResponseDTO getFollowedPostList(int userId, String order) {
        User user = userRepositoryImple.findUserById(userId);
        FollowedPostListResponseDTO followedPostListResponseDTO=null;
        if(user !=null){
            followedPostListResponseDTO = userRepositoryImple.getFollowedPostList(userId,order);
        }
        return followedPostListResponseDTO;
    }
*/

}
