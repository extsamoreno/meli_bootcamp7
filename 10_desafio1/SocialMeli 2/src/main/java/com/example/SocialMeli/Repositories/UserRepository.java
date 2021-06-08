package com.example.SocialMeli.Repositories;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Mapper.PostMapper;
import com.example.SocialMeli.Services.Mapper.ProductMapper;
import com.example.SocialMeli.Services.Mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository implements iUserRepository{

    private List<User> users= this.loadDataBase();
    private List<Post> posts= new ArrayList<>();
    private List<Product> products= new ArrayList<>();
    @Override
    public FollowDTO follow(int followerID, int followedID) throws UserNotFoundException {

        User follower = this.findUserByID(followerID);
        User followed = this.findUserByID(followedID);

        followed.addFollower(follower.getId());
        follower.addFollowed(followed.getId());

        return new FollowDTO(followedID,followerID, "Follow");
    }

    @Override
    public FollowCountDTO getFollowersCount(int userId) throws UserNotFoundException {

        User user = this.findUserByID(userId);

        return new FollowCountDTO(user.getId(), user.getName(), user.getFollowers().size());
    }

    @Override
    public FollowersDTO getFollowers(int userId) throws UserNotFoundException {
        User user = this.findUserByID(userId);
        List<UserDTO> followerDTOs = this.getUserDTOListByIds(user.getFollowers());

        return new FollowersDTO(user.getId(), user.getName(), followerDTOs);
    }

    @Override
    public FollowedDTO getFollowed(int userId) throws UserNotFoundException {

        User user = this.findUserByID(userId);
        List<UserDTO> followerDTOs = this.getUserDTOListByIds(user.getFollowedBy());
        return new FollowedDTO(user.getId(), user.getName(), followerDTOs);
    }

    @Override
    public void makePost(PostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {

            Post post = PostMapper.toPost(postDTO);
            Product product = ProductMapper.toProduct(postDTO.getDetail());
            User user = this.findUserByID(post.getUserId());

            this.savePost(post);
            this.saveProduct(product);
            user.addPost(post.getId());



    }
    private void saveProduct(Product product) throws ProductIdInUseException {

        if(!this.isProductIdUsed(product.getId())){
            this.products.add(product);
        }
        else{
            throw new ProductIdInUseException(product.getId());
        }

    }
    private void savePost(Post post) throws PostIdInUseException {

        if(!this.isPostIdUsed(post.getId())){
            this.posts.add(post);
        }
        else{
            throw new PostIdInUseException(post.getId());
        }

    }
    private Boolean isPostIdUsed(int postId){
        try{
            Post post = this.findPostByID(postId);
            return true;
        }
        catch (PostNotFoundException e){
            return false;
        }
    }
    private Boolean isProductIdUsed(int productId){
        try{
            Product product = this.findProductByID(productId);
            return true;
        }
        catch (ProductNotFoundException e){
            return false;
        }
    }
    private List<UserDTO> getUserDTOListByIds(List<Integer> UserIds) throws UserNotFoundException {

        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < UserIds.size(); i++) {
            User user = this.findUserByID(UserIds.get(i));
            userDTOS.add(UserMapper.toDTO(user));
        }
        return userDTOS;

    }
    private int findPostIndexByID(int postId) throws PostNotFoundException {

        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == postId ){
                return i;
            }
        }
        throw new PostNotFoundException(postId);
    }
    private Post findPostByID(int postId) throws PostNotFoundException {

        return posts.get(this.findPostIndexByID(postId));
    }
    private int findProductIndexByID(int productId) throws ProductNotFoundException{

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId ){
                return i;
            }
        }
        throw new ProductNotFoundException(productId);
    }
    private Product findProductByID(int productId) throws ProductNotFoundException {

        return products.get(this.findProductIndexByID(productId));
    }
    private int findUserIndexByID(int userId) throws UserNotFoundException{

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId ){
                return i;
            }
        }
        throw new UserNotFoundException(userId);
    }
    private User findUserByID(int userId) throws UserNotFoundException{

        return users.get(this.findUserIndexByID(userId));
    }
    public List<User> getUsers(){

        return this.users;
    }
    private List<User> loadDataBase(){

        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users = null;
        try{
            users = objectMapper.readValue(file, typeRef);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return users;
    }
}
