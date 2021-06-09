package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.entity.Post;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;
import java.util.List;

public interface PostService {

    void addNewPost(NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException;
    List<Post> getRecentPosts(Integer id) throws UserIdNotFoundException;
}
