package com.spring.desafioSpring.Services.Mappers;

import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.DTOs.PostWithoutIdUserDTO;
import com.spring.desafioSpring.DTOs.ProductDTO;
import com.spring.desafioSpring.Models.Post;
import com.spring.desafioSpring.Models.Product;

public class PostMapper {

    public static Post postDtoToPost(PostDTO dto){
        Post post = new Post();
        post.setUserId(dto.getUserId());
        post.setId_post(dto.getId_post());
        post.setDate(dto.getDate());
        post.setDetail(productDtoToProduct(dto.getDetail()));
        post.setCategory(dto.getCategory());
        post.setPrice(dto.getPrice());
        post.setHasPromo(dto.isHasPromo());
        post.setDiscount(dto.getDiscount());
        return post;
    }

    public static PostWithoutIdUserDTO postToPostWithoutIdUserDTO(Post post){
        PostWithoutIdUserDTO dto = new PostWithoutIdUserDTO();
        dto.setId_post(post.getId_post());
        dto.setDate(post.getDate());
        dto.setDetail(productToProductDTO(post.getDetail()));
        dto.setCategory(post.getCategory());
        dto.setPrice(post.getPrice());
        dto.setHasPromo(post.isHasPromo());
        dto.setDiscount(post.getDiscount());
        return dto;
    }

    public static ProductDTO productToProductDTO(Product product){
        ProductDTO dto = new ProductDTO();
        dto.setProduct_id(product.getProduct_id());
        dto.setProductName(product.getProductName());
        dto.setBrand(product.getBrand());
        dto.setType(product.getType());
        dto.setColor(product.getColor());
        dto.setNotes(product.getNotes());
        return  dto;
    }

    public static Product productDtoToProduct(ProductDTO dto){
        Product product = new Product();
        product.setProduct_id(dto.getProduct_id());
        product.setProductName(dto.getProductName());
        product.setBrand(dto.getBrand());
        product.setType(dto.getType());
        product.setColor(dto.getColor());
        product.setNotes(dto.getNotes());
        return product;
    }
}
