package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.exception.PostAlreadyExistsException;
import com.bootcamp.desafio1.exception.ProductAlreadyExistsException;
import com.bootcamp.desafio1.exception.UserNotFoundException;
import com.bootcamp.desafio1.model.Post;
import com.bootcamp.desafio1.model.Product;
import com.bootcamp.desafio1.repository.post.IPostRepository;
import com.bootcamp.desafio1.repository.product.IProductRepository;
import com.bootcamp.desafio1.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IUserService userServiceImpl;

    @Autowired
    IUserRepository userRepositoryImpl;

    @Autowired
    IPostRepository postRepositoryImpl;

    @Autowired
    IProductRepository productRepositoryImpl;


    @Override
    public void insertNewPost(NewPostDTO newPostDTO) throws PostAlreadyExistsException, ProductAlreadyExistsException, UserNotFoundException {

        int userId = newPostDTO.getUserId();
        int postId = newPostDTO.getPostId();
        int productId = newPostDTO.getDetail().getProductId();

        if(userRepositoryImpl.userIdExists(userId)){
            if( ! postRepositoryImpl.postIdExists(postId) ){
                if( ! productRepositoryImpl.productIdExists(productId) ){

                    // Add the PostId in the posts of the User
                    userServiceImpl.addPostId(userId, postId);

                    // Generate the Post and add in the Data Base
                    Post post = Mapper.NewPostToPost(newPostDTO);
                    postRepositoryImpl.addPostInDB(post);

                    // Generate the Product and add in the Data Base
                    Product product = Mapper.NewPostToProduct(newPostDTO);
                    productRepositoryImpl.addProductInDB(product);
                }
                else
                    throw new ProductAlreadyExistsException(productId);
            }
            else
                throw new PostAlreadyExistsException(postId);
        }
        else
            throw new UserNotFoundException(userId);
    }
}
