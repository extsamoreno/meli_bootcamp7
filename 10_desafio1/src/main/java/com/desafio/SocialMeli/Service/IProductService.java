package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.DTO.FollowedPostListDTO;
import com.desafio.SocialMeli.DTO.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.ProductDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;

public interface IProductService {

    ProductDTO createProduct (ProductDTO productDTO) throws ProductExistsException;

    PostWithUserDTO newPost(PostWithUserDTO postDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException;

    FollowedPostListDTO getFollowedPosts (int userId);
}
