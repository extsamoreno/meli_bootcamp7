package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.dtos.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PostService {
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException;
    public void newPromoPost(PostPromoDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException;
    public ListPostDTO getFollowedPostList(int userId, Optional<String> order) throws UserNotFoundException;
    public ProductUserPromoDTO getProductPromoCount(int userId) throws UserNotFoundException;
    public ListPostPromoDTO getProductsPromo(int userId) throws UserNotFoundException;
}
