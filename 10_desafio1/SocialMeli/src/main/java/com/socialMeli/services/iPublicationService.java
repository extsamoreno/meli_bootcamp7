package com.socialMeli.services;

import com.socialMeli.exceptions.FailCreatePostException;
import com.socialMeli.exceptions.InvalidDateException;
import com.socialMeli.exceptions.UserNotFoundException;
import com.socialMeli.exceptions.WrongCriteriaOrderException;
import com.socialMeli.models.DTOs.PostsDTO;
import com.socialMeli.models.DTOs.PromoPostsCountDTO;
import com.socialMeli.models.DTOs.PromoPostsListDTO;
import com.socialMeli.models.PromoPost;
import com.socialMeli.models.StandardPost;
import com.socialMeli.models.Seller;

import java.time.LocalDate;

public interface iPublicationService {

    Void newPost (StandardPost post) throws FailCreatePostException, InvalidDateException;
    void validateDate(LocalDate date) throws InvalidDateException;
    PostsDTO listPostFollowedSellers (Integer userId) throws UserNotFoundException;
    Seller orderPostsByDate(Integer userId, String order) throws UserNotFoundException, WrongCriteriaOrderException;
    Void newPromoPost (PromoPost promoPost) throws FailCreatePostException, InvalidDateException;
    PromoPostsCountDTO countPromoPosts (Integer sellerId) throws UserNotFoundException;
    PromoPostsListDTO listPromoPosts (Integer sellerId) throws UserNotFoundException;
}
