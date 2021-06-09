package com.meli.socialmeli.model.service;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.*;
import com.meli.socialmeli.model.exception.*;

public interface ServiceSocialMeli {
    void setFollowerTo(int userId, int userIdToFollow) throws IdNotFoundException, NonSellerUserException, RepeatFollowerException;
    UserSellerCountDTO getUserSellerCountDTO(int userId) throws NonSellerUserException, IdNotFoundException;
    UserSellerListDTO getUserSellerListDTO(int userId, String order) throws NonSellerUserException, IdNotFoundException, ErrorOrderParamNameException;
    UserListDTO getUserListDTO(int userId, String order) throws IdNotFoundException, ErrorOrderParamNameException;
    void createNewPost(Post post) throws IdNotFoundException, NonSellerUserException, PostIdAlreadyExistingException;
    UserListPostDTO getListPostbyUser(int userId, String order) throws IdNotFoundException, ErrorOrderParamDateException;
    void removeFollowerTo(int userId, int userIdUnFollow) throws IdNotFoundException, NonSellerUserException, NonExistentFolloweException;
    UserSellerCountPromoDTO getUserSellerCountPromoDTO(int userId) throws IdNotFoundException, NonSellerUserException;
    UserSellerListPromoDTO getUserSellerListPromoDTO(int userId) throws IdNotFoundException, NonSellerUserException;
}
