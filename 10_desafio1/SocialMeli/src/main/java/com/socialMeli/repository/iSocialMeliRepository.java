package com.socialMeli.repository;

import com.socialMeli.exceptions.*;
import com.socialMeli.models.Post;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.Seller;
import com.socialMeli.models.User;

import java.util.List;

public interface iSocialMeliRepository {

    List<User> loadDatabase(String pathFile) throws FailLoadDatabase;
    void loadUsersHashmap() throws FailLoadDatabase;
    void loadSellersHashMap ();

    User findUserById(Integer id) throws UserNotFoundException;
    Seller findSellerById(Integer id) throws UserNotFoundException;
    Integer findByUser (Object user) throws UserIdNotFoundException;
    void newPost (Post post) throws FailCreatePostException, InvalidDateException;
    void newPost(PromoPost newPromoPost) throws FailCreatePostException;
}
