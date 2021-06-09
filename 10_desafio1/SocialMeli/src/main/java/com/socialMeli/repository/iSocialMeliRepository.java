package com.socialMeli.repository;

import com.socialMeli.exceptions.*;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.StandardPost;
import com.socialMeli.models.User;

import java.util.List;

public interface iSocialMeliRepository {

    List<Object> loadDatabase(String pathFile) throws FailLoadDatabase;

    Object findById(Integer id) throws UserNotFoundException;
    Integer findByUser (Object user) throws UserIdNotFoundException;
    void newPost (StandardPost post) throws FailCreatePostException, InvalidDateException;
    void updateDatabase(List<User> users, String pathFile) throws FailUploadDatabase;
    void newPromoPost(PromoPost newPromoPost) throws FailCreatePostException;
}
