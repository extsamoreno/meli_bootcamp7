package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.dto.ProductDTO;
import com.bootcamp.desafio1.dto.response.*;
import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.model.Post;
import com.bootcamp.desafio1.model.Product;
import com.bootcamp.desafio1.model.User;

import java.util.ArrayList;

public abstract class Mapper {

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }


    public static CountFollowersDTO toCountFollowersDTO(User user, int followers_count){
        return new CountFollowersDTO(user.getUserId(), user.getUserName(), followers_count);
    }


    public static FollowersListDTO toFollowersListDTO(User user, ArrayList<UserDTO> followers){
        return new FollowersListDTO(user.getUserId(), user.getUserName(), followers);
    }


    public static FollowedListDTO toFollowedListDTO(User user, ArrayList<UserDTO> followed){
        return new FollowedListDTO(user.getUserId(), user.getUserName(), followed);
    }


    public static Post NewPostToPost(NewPostDTO newPostDTO){
        Post post = new Post();
        post.setUserId(newPostDTO.getUserId());
        post.setPostId(newPostDTO.getPostId());
        post.setDate(newPostDTO.getDate());
        post.setProductId(newPostDTO.getDetail().getProductId());
        post.setCategory(newPostDTO.getCategory());
        post.setPrice(newPostDTO.getPrice());
        post.setHasPromo(newPostDTO.isHasPromo());
        post.setDiscount(newPostDTO.getDiscount());
        return post;
    }


    public static Product NewPostToProduct(NewPostDTO newPostDTO){
        ProductDTO newProductDTO = newPostDTO.getDetail();
        Product product = new Product();

        product.setProductId(newProductDTO.getProductId());
        product.setProductName(newProductDTO.getProductName());
        product.setType(newProductDTO.getType());
        product.setBrand(newProductDTO.getBrand());
        product.setColor(newProductDTO.getColor());
        product.setNotes(newProductDTO.getNotes());
        return product;
    }


    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getProductId(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }


    public static PostDTO toPostDTO(Post post, ProductDTO productDTO){
        return new PostDTO(post.getPostId(), post.getDate(), productDTO, post.getCategory(), post.getPrice(), post.isHasPromo(), post.getDiscount());
    }


    public static PostsFollowedListDTO toPostsFollowedListDTO(User user, ArrayList<PostDTO> posts){
        return new PostsFollowedListDTO(user.getUserId(), posts);
    }


    public static CountPromoDTO toCountPromoDTO(User user, int promoCount){
        return new CountPromoDTO(user.getUserId(), user.getUserName(), promoCount);

    }


    public static PromoListDTO toPromoListDTO(User user, ArrayList<PostDTO> posts){
        return new PromoListDTO(user.getUserId(), user.getUserName(), posts);
    }

}
