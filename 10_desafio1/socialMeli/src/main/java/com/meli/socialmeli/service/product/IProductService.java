package com.meli.socialmeli.service.product;

import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException;

   FollowedPublicationDTO followedRecentsPublications(Integer userId) throws IdNotFoundException;
}
