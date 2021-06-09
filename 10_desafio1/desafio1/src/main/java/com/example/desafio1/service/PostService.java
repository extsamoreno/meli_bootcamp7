package com.example.desafio1.service;

import com.example.desafio1.exception.ProductInconsistencyException;
import com.example.desafio1.exception.ProductNotFoundException;
import com.example.desafio1.exception.PostIdAlreadyInUseException;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.ProductPost;
import com.example.desafio1.repository.IProductPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PostService implements IPostService{

    @Autowired
    IProductPostRepository iProductPostRepository;

    @Autowired
    IProductService iProductService;


    @Override
    public String createPost(ProductPost productPost)
            throws ProductNotFoundException, ProductInconsistencyException,
            PostIdAlreadyInUseException
    {
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
}
