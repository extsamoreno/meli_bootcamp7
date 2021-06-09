package meli.springchallenge.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.exceptions.UserNotValidException;

public interface IProductService {

    void createPost(PostDTO post);

    FollowedPostDTO getFollowedPosts(int userId, String order);
}

