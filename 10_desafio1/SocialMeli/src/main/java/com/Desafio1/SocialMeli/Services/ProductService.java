package com.Desafio1.SocialMeli.Services;

import com.Desafio1.SocialMeli.DTOS.FollowedPostListDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.NotSellerException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.Post;
import com.Desafio1.SocialMeli.Models.User;
import com.Desafio1.SocialMeli.Repositories.IPostRepository;
import com.Desafio1.SocialMeli.Repositories.IProductRepository;
import com.Desafio1.SocialMeli.Utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService implements IProductService {
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
            if (!seller.isSeller()) {
                seller.setSeller(true);
                iUserService.updateUser(seller);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public FollowedPostListDTO getFollowedPostListByUserId(int userId, String sortBy) throws UserNotFoundException {
        FollowedPostListDTO followedPostListDTO = new FollowedPostListDTO();
        try {
            //Verifico que id sea valido
            User user = iUserService.searchUserById(userId);

            //Si es valido busco los post de sus vendedores
            List<Post> postList = iUserService.getFollowedPostList(user.getFollowed());

            //Ordeno la lista de post segun criterio elegido
            postList.sort((a, b) -> Utils.sortBy(a.getDate(), b.getDate(), sortBy));

            followedPostListDTO.setUserId(userId);
            followedPostListDTO.setPostList(postList);
        }
        catch (Exception ex) {
            throw ex;
        }
        return followedPostListDTO;
    }
}
