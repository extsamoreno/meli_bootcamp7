package com.example.socialmeli.services;

import com.example.socialmeli.dtos.post.PostListDTO;
import com.example.socialmeli.dtos.post.PromoCountDTO;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.postExceptions.MissingDataException;
import com.example.socialmeli.exceptions.postExceptions.PostAlreadyExistException;
import com.example.socialmeli.models.Post;
import org.springframework.http.HttpStatus;

public interface IPostService {
    HttpStatus newPost(Post post) throws MissingDataException, PostAlreadyExistException, UserNotFoundException;
    PostListDTO getPostByUserId(Integer userId, String name, String order) throws UserNotFoundException;
    PromoCountDTO promoCount(Integer useriD) throws UserNotFoundException, MerchantNotFoundException;
    PostListDTO listPromoProductsByUserid(Integer userId) throws MerchantNotFoundException;
}
