package com.reto1.demo.Service;

import com.reto1.demo.Exception.*;
import com.reto1.demo.Model.DTO.PostObjects.LastPostDTO;
import com.reto1.demo.Model.DTO.PostObjects.PromoPostCount;
import com.reto1.demo.Model.DTO.UserObjets.UserPromoPostListDTO;
import com.reto1.demo.Model.Post;

public interface IPostService {

    String creatPost(Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException;

    LastPostDTO lastPosts(int userId) throws UserIdNotFoundException, UserNotFollowException;

    LastPostDTO orderLastPost(int userId, String order) throws UserNotFollowException, UserIdNotFoundException, OrderNotFoundException;

    PromoPostCount countPromoPost(int userId) throws UserNotFollowException, UserIdNotFoundException;;

    UserPromoPostListDTO listPromoPost(int userId) throws UserNotFollowException, UserIdNotFoundException;
}
