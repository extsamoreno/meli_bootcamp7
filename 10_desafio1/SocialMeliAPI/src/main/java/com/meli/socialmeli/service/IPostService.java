package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.*;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.dto.PostDTOAllPostList;
import com.meli.socialmeli.service.dto.PostDTOFollowedList;
import com.meli.socialmeli.service.dto.PostDTOPromoCount;
import org.springframework.http.HttpStatus;

public interface IPostService {
    public HttpStatus addNewPost(Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException;
    public PostDTOFollowedList getFollowedUserPosts(int userId, String order) throws IncorrectOrderTypeException, UserNotFoundException;
    public HttpStatus addNewPromotionPost(Post post) throws MissingDataException, UserNotFoundException, PostIdAlreadyExistException, OverActualDateException;
    public PostDTOAllPostList getAllPromotionPost(int userId) throws UserNotFoundException;
    public PostDTOPromoCount getPostPromoCount(int userId) throws UserNotFoundException;
}
