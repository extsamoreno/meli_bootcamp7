package com.meli.socialmeli.service.product;

import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import com.meli.socialmeli.dto.user.UserWithPromoCountDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.service.orderType.PublicationOrderType;

public interface IProductService {
    void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException;

    FollowedPublicationDTO followedRecentPublications(Integer userId, PublicationOrderType order) throws IdNotFoundException;

    void createPostWithPromo(PublicationWithPromoDTO post) throws InvalidDateFormatException, CanNotCreatePostException;

    UserWithPromoCountDTO promoCountOf(Integer userId) throws IdNotFoundException;
}
