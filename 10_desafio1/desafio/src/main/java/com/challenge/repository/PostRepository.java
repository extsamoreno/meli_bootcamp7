package com.challenge.repository;

import com.challenge.entity.Post;
import com.challenge.exception.PostIdAlreadyExistsException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PostRepository {

    void addNewProduct(Post post) throws PostIdAlreadyExistsException, IOException;
}
