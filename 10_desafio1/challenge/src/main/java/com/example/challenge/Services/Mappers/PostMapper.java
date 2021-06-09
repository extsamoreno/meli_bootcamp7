package com.example.challenge.Services.Mappers;

import com.example.challenge.Models.Post;
import com.example.challenge.Models.Product;
import com.example.challenge.Services.DTOs.PostDTO;
import com.example.challenge.Services.DTOs.PostPromotionDTO;
import com.example.challenge.Services.DTOs.ProductDTO;

public class PostMapper {

   public static Post postDtoToPost(PostDTO postDTO){
        Post post =  new Post();
        ProductDTO productDTO = postDTO.getProduct();
        Product product = new Product();
        post.setUserId(postDTO.getUserId());
        post.setId(postDTO.getId());
        post.setDate(postDTO.getDate());
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setType(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setNotes(productDTO.getNotes());
        post.setProduct(product);
        post.setCategoryId(postDTO.getCategoryId());
        post.setPrice(postDTO.getPrice());
        return post;
    }

     public static PostDTO postToPostDTO(Post post){
          PostDTO postDTO =  new PostDTO();
          Product product = post.getProduct();
          ProductDTO productDTO = new ProductDTO();
          postDTO.setUserId(post.getUserId());
          postDTO.setId(post.getId());
          postDTO.setDate(post.getDate());
          productDTO.setId(product.getId());
          productDTO.setName(product.getName());
          productDTO.setType(product.getName());
          productDTO.setBrand(product.getBrand());
          productDTO.setColor(product.getColor());
          productDTO.setNotes(product.getNotes());
          postDTO.setProduct(productDTO);
          postDTO.setCategoryId(post.getCategoryId());
          postDTO.setPrice(post.getPrice());
          return postDTO;
     }

     public static Post postPromotionDtoToPost(PostPromotionDTO postDTO){
          Post post =  new Post();
          ProductDTO productDTO = postDTO.getProduct();
          Product product = new Product();
          post.setUserId(postDTO.getUserId());
          post.setId(postDTO.getId());
          post.setDate(postDTO.getDate());
          product.setId(productDTO.getId());
          product.setName(productDTO.getName());
          product.setType(productDTO.getName());
          product.setBrand(productDTO.getBrand());
          product.setColor(productDTO.getColor());
          product.setNotes(productDTO.getNotes());
          post.setProduct(product);
          post.setCategoryId(postDTO.getCategoryId());
          post.setPrice(postDTO.getPrice());
          post.setDiscount(postDTO.getDiscount());
          post.setHasPromo(postDTO.getHasPromo());
          return post;
     }

     public static PostPromotionDTO postToPostPromotionDTO(Post post){
          PostPromotionDTO postDTO =  new PostPromotionDTO();
          Product product = post.getProduct();
          ProductDTO productDTO = new ProductDTO();
          postDTO.setUserId(post.getUserId());
          postDTO.setId(post.getId());
          postDTO.setDate(post.getDate());
          productDTO.setId(product.getId());
          productDTO.setName(product.getName());
          productDTO.setType(product.getName());
          productDTO.setBrand(product.getBrand());
          productDTO.setColor(product.getColor());
          productDTO.setNotes(product.getNotes());
          postDTO.setProduct(productDTO);
          postDTO.setCategoryId(post.getCategoryId());
          postDTO.setPrice(post.getPrice());
          postDTO.setDiscount( post.getDiscount());
          postDTO.setHasPromo(post.getHasPromo());
          return postDTO;
     }
}
