package meli.springchallenge.services;

import meli.springchallenge.dtos.CountPromoDTO;
import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.dtos.PostsListDTO;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;

public interface IProductService {

    void createPost(PostDTO post) throws ProductIdNotValidException, PostIdNotValidException, UserNotValidException;

    FollowedPostDTO getFollowedPosts(int userId, String order, int daysBefore) throws UserNotValidException;

    CountPromoDTO countPromoPost(int userId) throws UserNotValidException;

    PostsListDTO getPostsByUserId(int userId, String filter) throws UserNotValidException;

    String deletePost(int postId) throws PostIdNotValidException;
}

