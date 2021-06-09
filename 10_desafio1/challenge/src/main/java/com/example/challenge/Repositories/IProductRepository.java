package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;

public interface IProductRepository {

   String addNewPost(Post post, User user) throws UserNotFoundException;

   String addNewPromoPost(Post post, User user) throws UserNotFoundException;

}
