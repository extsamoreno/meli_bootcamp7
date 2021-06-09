package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.services.dtos.ListPostDTO;
import com.socialmeli.socialmeli.services.dtos.PostDTO;

import java.text.ParseException;
import java.util.List;

public interface PostService {
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException;
    public ListPostDTO getFollowedPostList(int userId) throws UserNotFoundException;
}
