package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.DTO.Post.ListPromoPostDTO;
import com.desafio.SocialMeli.DTO.Post.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.Post.PromoCountDTO;
import com.desafio.SocialMeli.DTO.Post.PromoPostWithUserDTO;
import com.desafio.SocialMeli.DTO.Product.ProductDTO;
import com.desafio.SocialMeli.DTO.User.FollowedPostListDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;

public interface IProductService {

    ProductDTO createProduct (ProductDTO productDTO) throws ProductExistsException;

    PostWithUserDTO newPost(PostWithUserDTO postDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException;

    FollowedPostListDTO getFollowedPosts14Days (int userId, String order) throws OrderNotFoundException;

    PromoPostWithUserDTO newPromoPost(PromoPostWithUserDTO promoPostWithUserDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException;

    PromoCountDTO getPromoPostCount(int userId) throws UserIdNotFoundException;

    ListPromoPostDTO getPromoPostListByUserId(int userId) throws UserIdNotFoundException;

}
