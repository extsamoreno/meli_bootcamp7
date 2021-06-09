package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.dto.PostDTO;
import com.challenge.entity.Post;
import com.challenge.enums.SortingPostsEnum;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;
import java.util.List;

public interface PostService {

    void addNewPost(NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException;
    List<PostDTO> getRecentPosts(Integer id, SortingPostsEnum sorting) throws UserIdNotFoundException;
    Integer getPromoPostsCount(Integer userId) throws UserIdNotFoundException;
}
