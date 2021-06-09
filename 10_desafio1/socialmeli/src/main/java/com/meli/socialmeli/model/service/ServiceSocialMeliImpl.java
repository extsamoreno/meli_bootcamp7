package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;
import com.meli.socialmeli.model.dao.repository.RepositoryPost;
import com.meli.socialmeli.model.dao.repository.RepositoryUsers;
import com.meli.socialmeli.model.dto.*;
import com.meli.socialmeli.model.exception.*;
import com.meli.socialmeli.model.mapper.PostMapper;
import com.meli.socialmeli.model.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceSocialMeliImpl implements ServiceSocialMeli{
    @Autowired
    private RepositoryUsers repositoryUsers;

    @Autowired
    private RepositoryPost repositoryPost;

    public void setFollowerTo(int userId, int userIdToFollow) throws IdNotFoundException, NonSellerUserException,
            RepeatFollowerException {
        User buyer = repositoryUsers.getUserById(userId);
        User seller = repositoryUsers.getUserById(userIdToFollow);
        if (buyer == null) {
            throw new IdNotFoundException(userId);
        }
        if (seller == null) {
            throw new IdNotFoundException(userIdToFollow);
        }
        if (!seller.isSeller()) {
            throw new NonSellerUserException(userIdToFollow);
        }
        if (seller.getUsersFollowed().contains(buyer)) {
            throw new RepeatFollowerException(userId);
        }
        seller.getUsersFollowed().add(buyer);
        seller.setCantFollowed(seller.getCantFollowed() + 1);
        buyer.getUsersFollowed().add(seller);
        buyer.setCantFollowed(buyer.getCantFollowed() + 1);
    }

    public UserSellerCountDTO getUserSellerCountDTO(int userId) throws NonSellerUserException, IdNotFoundException {
        User user = repositoryUsers.getUserById(userId);
        if (user == null) {
            throw new IdNotFoundException(userId);
        }
        if (!user.isSeller()) {
            throw new NonSellerUserException(userId);
        }
        return UsersMapper.changeToUserSellerCountDTO(user);
    }

    public UserSellerListDTO getUserSellerListDTO(int userId, String order) throws NonSellerUserException,
            IdNotFoundException {
        User user = repositoryUsers.getUserById(userId);
        if (user == null) {
            throw new IdNotFoundException(userId);
        }
        if (!user.isSeller()) {
            throw new NonSellerUserException(userId);
        }
        return UsersMapper.changeToUserSellerListDTO(user);
    }

    public UserListDTO getUserListDTO(int userId) throws IdNotFoundException {
        User user = repositoryUsers.getUserById(userId);
        if (user == null) {
            throw new IdNotFoundException(userId);
        }
        return UsersMapper.changeToUserListDTO(user);
    }

    public void createNewPost(Post post) throws IdNotFoundException, NonSellerUserException,
            PostIdAlreadyExistingException {
        User user = repositoryUsers.getUserById(post.getUserId());
        Post newpost = repositoryPost.getPostById(post.getIdPost());
        if (user == null) {
            throw new IdNotFoundException(post.getUserId());
        }
        if (!user.isSeller()) {
            throw new NonSellerUserException(post.getUserId());
        }
        if (newpost != null) {
            throw new PostIdAlreadyExistingException(post.getIdPost());
        }
        repositoryPost.createNewPost(post);
    }

    public UserListPostDTO getListPostbyUser(int userId) throws IdNotFoundException {
        User user = repositoryUsers.getUserById(userId);
        if (user == null) {
            throw new IdNotFoundException(userId);
        }
        UserListPostDTO userListPostDTO = UsersMapper.changeToUserListPostDTO(user);
        ArrayList<User> usersFollowed = user.getUsersFollowed();
        for (int i = 0; i < usersFollowed.size(); i++) {
            ArrayList<Post> listPost = usersFollowed.get(i).getPost();
            for (int j = 0; j < listPost.size(); j++) {
                Post post = listPost.get(j);
                userListPostDTO.getPosts().add(PostMapper.changeToPostDTO(post));
            }
        }
        return userListPostDTO;
    }

    public void removeFollowerTo(int userId, int userIdUnFollow) throws IdNotFoundException, NonSellerUserException,
            NonExistentFolloweException {
        User buyer = repositoryUsers.getUserById(userId);
        User seller = repositoryUsers.getUserById(userIdUnFollow);
        if (buyer == null) {
            throw new IdNotFoundException(userId);
        }
        if (seller == null) {
            throw new IdNotFoundException(userIdUnFollow);
        }
        if (!seller.isSeller()) {
            throw new NonSellerUserException(userIdUnFollow);
        }
        if(!seller.getUsersFollowed().contains(buyer)) {
            throw new NonExistentFolloweException(userIdUnFollow);
        }
        seller.getUsersFollowed().remove(buyer);
        seller.setCantFollowed(seller.getCantFollowed() - 1);
        buyer.getUsersFollowed().remove(seller);
        buyer.setCantFollowed(buyer.getCantFollowed() - 1);
    }
}
