package com.socialmedia.socialmedia.mappers;

import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.repositories.entities.Product;
import com.socialmedia.socialmedia.services.dtos.PostDTO;
import com.socialmedia.socialmedia.services.dtos.ProductDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedDTO;
import com.socialmedia.socialmedia.services.dtos.UserWithFollowedPostsDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductMapper {
    public static Product productDtoToProduct(ProductDTO productDTO) {
        var product = new Product();

        product.setId(productDTO.getProductId());
        product.setBrand(productDTO.getBrand());
        product.setColor(productDTO.getColor());
        product.setName(productDTO.getProductName());
        product.setNotes(productDTO.getNotes());
        product.setType(productDTO.getType());

        return product;
    }

    public static ProductDTO productToProductDTO(Product product) {
        var productDTO = new ProductDTO();

        productDTO.setProductId( product.getId());
        productDTO.setProductName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setColor(product.getColor());
        productDTO.setNotes(product.getNotes());
        productDTO.setType(product.getType());

        return productDTO;
    }

    public static Post postDtoToPost(PostDTO postDTO) {
        Post post = new Post();

        post.setId(postDTO.getPostId());
        post.setProductId(postDTO.getDetail().getProductId());
        post.setCategory(postDTO.getCategory());
        post.setPrice(postDTO.getPrice());
        post.setDate(postDTO.getDate());
        post.setUserId(postDTO.getUserId());

        return post;
    }

    public static UserWithFollowedPostsDTO userAndPostsToUserWithFollowedPostsDTO(UserWithFollowedDTO user, List<Post> posts) {
        var result = new UserWithFollowedPostsDTO();
        result.setId(user.getId());
        result.setUsername(user.getUsername());

        result.setPosts(postsToPostDTOs(posts));
        return result;
    }
    public static List<PostDTO> postsToPostDTOs(List<Post> posts) {
        List<PostDTO> postDTOS = new ArrayList<>();
        for (Post post: posts) {
            postDTOS.add(postToPostDTO(post));
        }
        return postDTOS;
    }

    public static PostDTO postToPostDTO(Post post) {
        PostDTO result = new PostDTO();

        result.setPostId(post.getId());
        result.setDate(post.getDate());
        result.setCategory(post.getCategory());
        result.setPrice(post.getPrice());
        result.setUserId(post.getUserId());

        return result;
    }
}
