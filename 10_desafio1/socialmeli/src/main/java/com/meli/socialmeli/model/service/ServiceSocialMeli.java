package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;

public interface ServiceSocialMeli {
    public void setFollowerTo(int userId, int userIdToFollow);
    public UserSellerCountDTO getUserSellerCountDTO(int userId);
    public UserSellerListDTO getUserSellerListDTO(int userId);
    public UserListDTO getUserListDTO(int userId);
    public void createNewPost(Post post);
    public UserListPostDTO getListPostbyUser(int userId);
}
