package com.example.desafio1.repository;

import com.example.desafio1.exception.post.PostAlreadyExistException;
import com.example.desafio1.exception.post.PostNotFoundException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.User;

import java.text.ParseException;
import java.util.ArrayList;

public interface iPostRepository {

    Post savePost(Post post) throws PostAlreadyExistException, UserNotFoundException;
    ArrayList<Post> findWeeksPosts(int weeksToFind);
    ArrayList<Post> findWeeksPostsByUserId(Integer id, Integer weeksToFind) throws UserNotFoundException;
}
