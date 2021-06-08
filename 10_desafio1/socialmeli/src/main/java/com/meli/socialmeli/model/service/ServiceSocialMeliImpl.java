package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dao.model.User;
import com.meli.socialmeli.model.dao.repository.RepositoryPost;
import com.meli.socialmeli.model.dao.repository.RepositoryUsers;
import com.meli.socialmeli.model.dto.*;
import com.meli.socialmeli.model.mapper.PostMapper;
import com.meli.socialmeli.model.mapper.UsersMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceSocialMeliImpl implements ServiceSocialMeli{
    @Autowired
    private RepositoryUsers repositoryUsers;

    @Autowired
    private RepositoryPost repositoryPost;

    public void setFollowerTo(int userId, int userIdToFollow) {
        User buyer = repositoryUsers.getUserById(userId);
        User seller = repositoryUsers.getUserById(userIdToFollow);
        if (buyer == null) {
            // Retornar con error de que no existe Usuario Comprador
        }
        if (seller == null) {
            // Retornar con error de que no existe Usuario Vendedor
        }
        if (!seller.isSeller()) {
            // Retornar con error de que solo se puede seguir Vendedores
        }
        seller.getUsersFollowed().add(buyer);
        seller.setCantFollowed(seller.getCantFollowed() + 1);

        buyer.getUsersFollowed().add(seller);
        buyer.setCantFollowed(buyer.getCantFollowed() + 1);
    }

    public UserSellerCountDTO getUserSellerCountDTO(int userId) {
        User user = repositoryUsers.getUserById(userId);
        if (!user.isSeller()) {
            // Responder con error de que no es un Vendedor
        }
        return UsersMapper.changeToUserSellerCountDTO(user);
    }

    public UserSellerListDTO getUserSellerListDTO(int userId) {
        User user = repositoryUsers.getUserById(userId);
        if (!user.isSeller()) {
            // Responder con error de que no es un Vendedor
        }
        return UsersMapper.changeToUserSellerListDTO(user);
    }

    public UserListDTO getUserListDTO(int userId) {
        User user = repositoryUsers.getUserById(userId);
        return UsersMapper.changeToUserListDTO(user);
    }

    public void createNewPost(Post post) {
        boolean isCreated = repositoryPost.createNewPost(post);
        if (!isCreated) {
            // Generar un error al ser creado
            System.out.println("POST NO CREADO !!!!!!!!!!!!!!");
        }
    }

    public UserListPostDTO getListPostbyUser(int userId) {
        User user = repositoryUsers.getUserById(userId);
        UserListPostDTO userListPostDTO = UsersMapper.changeToUserListPostDTO(user);
        ArrayList<User> usersFollowed = user.getUsersFollowed();
        for (int i = 0; i < usersFollowed.size(); i++) {
            ArrayList<Integer> listPost = usersFollowed.get(i).getPost();
            for (int j = 0; j < listPost.size(); j++) {
                Post post = repositoryPost.getPostById(listPost.get(j));
                userListPostDTO.getPosts().add(PostMapper.changeToPostDTO(post));
            }
        }
        return userListPostDTO;
    }


}
