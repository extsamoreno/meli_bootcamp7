package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.PostIdAlreadyInUseException;
import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.ProductPost;
import com.example.desafio1.repository.IProductPostRepository;
import com.example.desafio1.repository.IUserRepository;
import com.example.desafio1.service.dto.postdto.PostDTO;
import com.example.desafio1.service.dto.postdto.UserPostListDTO;
import com.example.desafio1.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService implements IPostService{

    @Autowired
    IProductPostRepository iProductPostRepository;

    @Autowired
    IProductService iProductService;

    @Autowired
    IUserRepository iUserRepository;


    @Override
    public String createPost(PostDTO postDTO)
            throws ProductNotFoundException, ProductInconsistencyException,
            PostIdAlreadyInUseException
    {
        ProductPost productPost = PostMapper.toProductPost(postDTO);

        //checking product consistency with repo
        Product product = productPost.getDetail();
        Product productFromCatalog = iProductService.checkProductConsistency(product);

        //updating post detail (product) from catalog
        productPost.setDetail(productFromCatalog);

        //create a post from an Id checked post
        iProductPostRepository.createNewPost(checkPostId(productPost));

        return "Todo OK.";

    }

    @Override
    public ProductPost checkPostId(ProductPost postRequest)
            throws PostIdAlreadyInUseException
    {
        int id = postRequest.getId_post();
        /*
        este key existe?
            si-> Exception y mostrar un id disponible.
         */
        if(iProductPostRepository.isUsedPostId(id))
        {
            throw new PostIdAlreadyInUseException(id, iProductPostRepository.validPostId());
        }

        return postRequest;
    }


    //Method for test queries only
    @Override
    public HashMap<Integer, ProductPost> getPosts() {
        return iProductPostRepository.getProductPostCatalog();
    }

    @Override
    public UserPostListDTO getUserPostListDTO(int userId, String order) throws UserNotFoundException {

        ArrayList<Integer> followedUsers = iUserRepository.getUserById(userId).getFollowed();

        ArrayList<ProductPost> recentPosts = new ArrayList<>();
        for (int followedUserId :
                followedUsers) {
            recentPosts.addAll(iProductPostRepository.getRecentPosts(followedUserId));
        }

        if (order.equalsIgnoreCase("date_asc"))
        {
            recentPosts.sort(Comparator.comparing((ProductPost::getDate)));
        }
        else if (order.equalsIgnoreCase("date_desc"))
        {
            recentPosts.sort(Collections.reverseOrder(Comparator.comparing((ProductPost::getDate))));
        }

        return PostMapper.toUserPostListDTO(userId, recentPosts);
    }

}
