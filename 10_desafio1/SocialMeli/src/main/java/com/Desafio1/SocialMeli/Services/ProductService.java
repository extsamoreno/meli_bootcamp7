package com.Desafio1.SocialMeli.Services;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.NotSellerException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.Post;
import com.Desafio1.SocialMeli.Models.User;
import com.Desafio1.SocialMeli.Repositories.IPostRepository;
import com.Desafio1.SocialMeli.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserService iUserService;

    @Override
    public void createNewPost(Post post) throws DuplicateIdException, UserNotFoundException {
        try {
            iPostRepository.createPost(post); //Creo el post
            iProductRepository.addProduct(post.getDetail()); //Agrego el producto al listado del productos

            User seller = iUserService.searchUserById(post.getUserId()); // Busco el usuario que realizo el posteo
            seller.getPosts().add(post); // Agrego el post a su listado de post
            if (!seller.isSeller()){
                seller.setSeller(true);
                iUserService.updateUser(seller);
            }
        }
        catch (Exception ex){
            throw  ex;
        }
    }
}
