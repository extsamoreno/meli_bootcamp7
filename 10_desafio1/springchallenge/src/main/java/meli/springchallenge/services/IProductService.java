package meli.springchallenge.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.followedPostDTO;

public interface IProductService {

    void createPost(PostDTO post);

    followedPostDTO getFollowedPosts(int userId);
}

