package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.User;
import com.meli.socialmeli.model.dao.repository.RepositoryUsers;
import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;
import com.meli.socialmeli.model.mapper.UsersMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSocialMeliImpl implements ServiceSocialMeli{
    @Autowired
    private RepositoryUsers repositoryUsers;

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

    
}
