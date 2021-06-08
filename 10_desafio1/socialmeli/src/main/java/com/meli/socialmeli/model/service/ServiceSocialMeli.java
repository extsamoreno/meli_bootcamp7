package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;

public interface ServiceSocialMeli {
    void setFollowerTo(int userId, int userIdToFollow);
    UserSellerCountDTO getUserSellerCountDTO(int userId);
    UserSellerListDTO getUserSellerListDTO(int userId);
    UserListDTO getUserListDTO(int userId);
    void createNewPost(Post post);
    UserListPostDTO getListPostbyUser(int userId);
    void removeFollowerTo(int userId, int userIdUnFollow);
}
