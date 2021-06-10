package com.meli.demo.services;

import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.exceptions.UnFollowException;


public interface SocialService {

    String Follow(int userid, int  usertofollow) throws FollowException;
    CountUsersDTO countUsers(int iduser);
    LisUsersResponseDTO listUsers(int iduser);
    ListSellersResponseDTO listVendedores(int iduser);
    String newPost(PostResponseDTO post) throws  PostException;
    ListSellersPostDTO listPostVendedors(int iduser);
    String unFollow(int userid, int  usertofollow) throws UnFollowException;
    ListSellersPostDTO orderDateAscDesc(int UserID, String order);
    ListSellersPostDTO orderNameAscDesc(int UserID, String order);
    String newPostDiscount(PostDTO poubli) throws PostDiscountException ;
    CountDiscountSelleDTO countDiscount(int ioUser);

    ListDiscountDTO listDiscount(int iduser);

    ListDiscountDTO orderDtoNameDesc(int UserID, String order);


}
