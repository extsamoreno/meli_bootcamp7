package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.Post;
import com.example.desafio_1.repository.IPostRepository;
import com.example.desafio_1.service.dto.PostDTO;
import com.example.desafio_1.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    @Autowired
    IProductService productService;

    @Autowired
    IUserService userService;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    PostMapper postMapper;

    @Override
    public void createPostByDTO(PostDTO postDTO) throws UserExceptionNotFound, UserExceptionWrongType, ProductExceptionNotFound, PostExceptionNotValid, ProductExceptionNotValid, PostExceptionNotExists, PostExceptionAlreadyExists {

        //validate fields
        validateDTO(postDTO);

        productService.existsProduct(postDTO.getDetail().getProduct_id());

        //validate user
        userService.existsUser(postDTO.getUserId());

        userService.checkInstance(postDTO.getUserId(), "seller");

        if(this.existsPost(postDTO.getId_post())) {
            throw new PostExceptionAlreadyExists(postDTO.getId_post()); // cant create a post with the same id
        }

        Post post = postMapper.toModel(postDTO);

        postRepository.add(post);
    }

    @Override
    public void createPost(Post post) {

    }

    public boolean existsPost(int postId) throws PostExceptionNotExists {
        return postRepository.getById(postId) != null;
    }

    private void validateDTO(PostDTO postDTO) throws ProductExceptionNotValid, PostExceptionNotValid {
        //Only capture the valdiation for post, because in the product service process the productException, not here
        try {
            Utils.validateIntGreaterThanZero(postDTO.getUserId(), "userId");
            //Utils.validateIntGreaterThanZero(postDTO.getId_post(), "id_post"); //if id is 0 or null, autogenereate in repo
            Utils.validateIntGreaterThanZero(postDTO.getCategory(), "category");
            Utils.validateDoubleGreaterThanZero(postDTO.getPrice(), "price");
            Utils.validateDate(postDTO.getDate(), "date");
        }
        catch(Exception e) {
            throw new PostExceptionNotValid(e.getMessage());
        }

        productService.validateDTO(postDTO.getDetail());
    }

}
