package com.example.challenge.Services.Mappers;

import com.example.challenge.Models.Post;
import com.example.challenge.Models.Product;
import com.example.challenge.Services.DTOs.PostDTO;
import com.example.challenge.Services.DTOs.PostPromotionDTO;
import com.example.challenge.Services.DTOs.ProductDTO;


public class PostMapper {

    public static Product productDTOToProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public static ProductDTO productToProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    public static Post postDtoToPost(PostDTO postDTO) {
        ProductDTO productDTO = postDTO.getProduct();
        Product product = productDTOToProduct(productDTO);
        return new Post(postDTO.getUserId(), postDTO.getId(), postDTO.getDate(), product, postDTO.getCategoryId(), postDTO.getPrice());
    }

    public static PostDTO postToPostDTO(Post post) {
        Product product = post.getProduct();
        ProductDTO productDTO = productToProductDTO(product);
        return new PostDTO(post.getUserId(), post.getId(), post.getDate(), productDTO, post.getCategoryId(), post.getPrice());
    }

    public static Post postPromotionDtoToPost(PostPromotionDTO postDTO) {

        ProductDTO productDTO = postDTO.getProduct();
        Product product = productDTOToProduct(productDTO);
        return new Post(postDTO.getUserId(), postDTO.getId(), postDTO.getDate(), product, postDTO.getCategoryId(), postDTO.getPrice(), postDTO.getHasPromo(), postDTO.getDiscount());

    }

    public static PostPromotionDTO postToPostPromotionDTO(Post postDTO) {

        Product productDTO = postDTO.getProduct();
        ProductDTO product = productToProductDTO(productDTO);
        return new PostPromotionDTO(postDTO.getUserId(), postDTO.getId(), postDTO.getDate(), product, postDTO.getCategoryId(), postDTO.getPrice(), postDTO.getHasPromo(), postDTO.getDiscount());

    }

}
