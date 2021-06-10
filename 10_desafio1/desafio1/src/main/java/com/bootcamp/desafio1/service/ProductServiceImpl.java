package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.ProductDTO;
import com.bootcamp.desafio1.dto.request.NewPostDTO;
import com.bootcamp.desafio1.dto.response.CountPromoDTO;
import com.bootcamp.desafio1.dto.response.PostDTO;
import com.bootcamp.desafio1.dto.response.PostsFollowedListDTO;
import com.bootcamp.desafio1.dto.response.PromoListDTO;
import com.bootcamp.desafio1.exception.*;
import com.bootcamp.desafio1.model.Post;
import com.bootcamp.desafio1.model.Product;
import com.bootcamp.desafio1.model.User;
import com.bootcamp.desafio1.repository.post.IPostRepository;
import com.bootcamp.desafio1.repository.product.IProductRepository;
import com.bootcamp.desafio1.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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


    @Override
    public PostsFollowedListDTO listPostsFollowed(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        User currentUser = userRepositoryImpl.getUserById(userId);
        ArrayList<User> followed = currentUser.getFollowed();

        // Generate the list of postId
        ArrayList<Integer> postIdList = new ArrayList<>();
        for (User x : followed) {
            for (int postId : x.getPosts()) {
                postIdList.add(postId);
            }
        }

        // Bring the Posts and Products
        ArrayList<PostDTO> finalList = new ArrayList<>();
        for (int postId : postIdList) {
            Post post = postRepositoryImpl.getPostById(postId);
            Product product = productRepositoryImpl.getProductById(post.getProductId()) ;

            // Generate the ProductDTO, PostDTO and add in the list
            ProductDTO productDTO = Mapper.toProductDTO(product);
            PostDTO postDTO = Mapper.toPostDTO(post, productDTO);
            finalList.add(postDTO);
        }
        return Mapper.toPostsFollowedListDTO(currentUser, finalList);
    }


    @Override
    public CountPromoDTO promoCount(int userId) throws UserNotFoundException, PostNotFoundException {
        User currentUser = userRepositoryImpl.getUserById(userId);
        ArrayList<Integer> posts = currentUser.getPosts();
        int promoCount = 0;
        for (Integer postId : posts){
            Post onePost = postRepositoryImpl.getPostById(postId);
            if(onePost.isHasPromo())
                promoCount++;
        }

        return Mapper.toCountPromoDTO(currentUser, promoCount);
    }


    @Override
    public PromoListDTO listPromos(int userId) throws UserNotFoundException, PostNotFoundException, ProductNotFoundException {
        User currentUser = userRepositoryImpl.getUserById(userId);
        ArrayList<Integer> postIdList = currentUser.getPosts();

        // Bring the Posts and Products
        ArrayList<PostDTO> finalList = new ArrayList<>();
        for (int postId : postIdList) {
            Post post = postRepositoryImpl.getPostById(postId);
            Product product = productRepositoryImpl.getProductById(post.getProductId()) ;

            // Generate the ProductDTO, PostDTO and add in the list
            ProductDTO productDTO = Mapper.toProductDTO(product);
            PostDTO postDTO = Mapper.toPostDTO(post, productDTO);

            if(post.isHasPromo())
                finalList.add(postDTO);
        }

        return Mapper.toPromoListDTO(currentUser, finalList);
    }
}
