package com.meli.socialmeli.service.product;

import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.InvalidDateFormatException;

public interface IProductService {
    void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException;
}
