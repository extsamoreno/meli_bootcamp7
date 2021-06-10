package com.socialmeli.desafio.service;

import com.socialmeli.desafio.Exception.FollowerNotRegisteredException;
import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;
import com.socialmeli.desafio.dto.*;
import com.socialmeli.desafio.model.PostModel;
import com.socialmeli.desafio.model.SellerModel;

import java.util.ArrayList;

public interface ISocialService {

    void follow(int idUsuario, int idVendedor) throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException;

    FollowersCountDTO getCountFollowers(int id) throws SellerIdNotFoundException;

    FollowersListDTO getFollowersList(int id, String order) throws SellerIdNotFoundException;

    void createPost(PostModel post) throws UserIdNotFoundException, SellerIdNotFoundException;

    void unfollow(int userId, int sellerId) throws UserIdNotFoundException, SellerIdNotFoundException, FollowerNotRegisteredException;

    PostOfFollowedSellerDTO postFollowedSellersTwoWeeks(int id, String order) throws UserIdNotFoundException;

    FollowedListDTO getFollowedList(int id, String order) throws UserIdNotFoundException;

    ArrayList<PostModel> getPostSellerTwoWeeks(SellerModel seller);

    void sortUserAsc(ArrayList<UserDTO> aSortear);

    void sortUserDesc(ArrayList<UserDTO> aSortear);

    void sortSellerAsc(ArrayList<SellerDTO> aSortear);

    void sortSellerDesc(ArrayList<SellerDTO> aSortear);

    CountPromoDTO countPromoBySeller (int sellerId) throws SellerIdNotFoundException;
    PromoListSellerDTO listPromo (int sellerId, String order) throws SellerIdNotFoundException;

}
