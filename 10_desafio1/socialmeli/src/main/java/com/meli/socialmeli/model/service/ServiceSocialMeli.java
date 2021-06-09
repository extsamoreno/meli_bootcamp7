package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListDTO;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.dto.UserSellerCountDTO;
import com.meli.socialmeli.model.dto.UserSellerListDTO;
import com.meli.socialmeli.model.exception.*;

public interface ServiceSocialMeli {
    void setFollowerTo(int userId, int userIdToFollow) throws IdNotFoundException, NonSellerUserException, RepeatFollowerException;
    UserSellerCountDTO getUserSellerCountDTO(int userId) throws NonSellerUserException, IdNotFoundException;
    UserSellerListDTO getUserSellerListDTO(int userId, String order) throws NonSellerUserException, IdNotFoundException, ErrorOrderParamNameException;
    UserListDTO getUserListDTO(int userId, String order) throws IdNotFoundException, ErrorOrderParamNameException;
    void createNewPost(Post post) throws IdNotFoundException, NonSellerUserException, PostIdAlreadyExistingException;
    UserListPostDTO getListPostbyUser(int userId, String order) throws IdNotFoundException, ErrorOrderParamDateException;
    void removeFollowerTo(int userId, int userIdUnFollow) throws IdNotFoundException, NonSellerUserException, NonExistentFolloweException;
}
