package com.reto1.demo.Service;

import com.reto1.demo.Exception.DateNotExistException;
import com.reto1.demo.Exception.DuplicatedPostException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.DTO.LastPostDTO;
import com.reto1.demo.Model.Post;

public interface IPostService {

    String creatPost(Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException;

    LastPostDTO lastPosts(int userId) throws UserIdNotFoundException;
}
