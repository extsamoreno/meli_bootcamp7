package com.meli.socialmeli.mapper;

import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.dto.ProductDetailDTO;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.models.ProductDetail;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public static PostDTO mapToPostDTO(int postId, Post post) {

        PostDTO postDTO = new PostDTO();

        postDTO.setUserId(post.getUserId());
        postDTO.setIdPost(postId);
        postDTO.setDate(post.getDate());
        postDTO.setDetail(mapToProductDetailDTO(post.getDetail()));
        postDTO.setCategory(post.getCategory());
        postDTO.setPrice(post.getPrice());

        return postDTO;
    }

    private static ProductDetailDTO mapToProductDetailDTO(ProductDetail productDetail) {

        ProductDetailDTO productDetailDTO = new ProductDetailDTO();

        productDetailDTO.setProductId(productDetail.getProductId());
        productDetailDTO.setProductName(productDetail.getProductName());
        productDetailDTO.setType(productDetail.getType());
        productDetailDTO.setBrand(productDetail.getBrand());
        productDetailDTO.setColor(productDetail.getColor());
        productDetailDTO.setNotes(productDetail.getNotes());

        return productDetailDTO;
    }

    public static Post mapToPost(PostDTO postDTO) {

        Post post = new Post();

        post.setUserId(postDTO.getUserId());
        post.setDate(postDTO.getDate());
        post.setDetail(mapToProductDetail(postDTO.getDetail()));
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());

        return post;
    }

    private static ProductDetail mapToProductDetail(ProductDetailDTO productDetailDTO) {

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productDetailDTO.getProductId());
        productDetail.setProductName(productDetailDTO.getProductName());
        productDetail.setType(productDetailDTO.getType());
        productDetail.setBrand(productDetailDTO.getBrand());
        productDetail.setColor(productDetailDTO.getColor());
        productDetail.setNotes(productDetailDTO.getNotes());

        return productDetail;
    }
}
