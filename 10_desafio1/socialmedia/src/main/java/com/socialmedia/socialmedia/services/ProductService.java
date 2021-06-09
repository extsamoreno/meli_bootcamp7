package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.PostInsertException;
import com.socialmedia.socialmedia.exceptions.ProductInsertException;
import com.socialmedia.socialmedia.exceptions.UserNotFoundException;
import com.socialmedia.socialmedia.mappers.ProductMapper;
import com.socialmedia.socialmedia.repositories.IProductRepository;
import com.socialmedia.socialmedia.repositories.entities.Post;
import com.socialmedia.socialmedia.repositories.entities.Product;
import com.socialmedia.socialmedia.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IUserService userService;

    @Override
    public void addNewProductWithPost(PostDTO postDTO) throws ProductInsertException, PostInsertException {
        Product product = ProductMapper.productDtoToProduct(postDTO.getDetail());
        //TODO: refact to product and post
        //TODO: Validate exist user
        //TODO: Validate exist product
        postDTO.setPostId(productRepository.addNewProduct(product));

        if (postDTO.getPostId() == 0) throw new ProductInsertException();

        Post post = ProductMapper.postDtoToPost(postDTO);

        int idPost = productRepository.addNewPost(post);

        if (idPost == 0) throw new PostInsertException();
    }

    @Override
    public UserWithFollowedPostsDTO getFollowedPostsByUser(int userId) throws UserNotFoundException {
        UserWithFollowedDTO userWithFollowed = userService.getFollowedByUser(userId);

        List<Post> allPostsFollowed = new ArrayList<>();

        for (UserDTO followedDTO : userWithFollowed.getFollowed()) {
            List<Post> postsByFollowed = productRepository.getPostsByUser(followedDTO.getId());
            allPostsFollowed.addAll(postsByFollowed);
        }
        var result = ProductMapper.userAndPostsToUserWithFollowedPostsDTO(userWithFollowed, allPostsFollowed);
        //TODO: add post to array detail in result
        return result;
    }
}
