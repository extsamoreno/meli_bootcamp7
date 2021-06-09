package meli.springchallenge.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;

public interface IProductService {

    void createPost(PostDTO post) throws ProductIdNotValidException, PostIdNotValidException, UserNotValidException;

    FollowedPostDTO getFollowedPosts(int userId, String order) throws UserNotValidException;
}

