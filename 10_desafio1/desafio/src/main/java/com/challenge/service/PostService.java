package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;

public interface PostService {

    void addNewPost(NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException;

}
