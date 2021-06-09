package com.reto1.demo.Service;

import com.reto1.demo.Exception.*;
import com.reto1.demo.Model.DTO.LastPostDTO;
import com.reto1.demo.Model.Post;

public interface IPostService {

    String creatPost(Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException;

    LastPostDTO lastPosts(int userId) throws UserIdNotFoundException, UserNotFollowException;

    LastPostDTO orderLastPost(int userId, String order) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;
}
