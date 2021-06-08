package com.example.demo.project.service;


import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.exception.UsersCantFollowThemselvesException;
import com.example.demo.project.service.dto.SellerDTO;
import com.example.demo.project.service.dto.UserDTO;

public interface IUserService {

    void follow(int userid, int useridtofollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException;
    SellerDTO getFollowerCount(int userid) throws UserIdNotFoundException;
    SellerDTO getFollowers(int userid) throws UserIdNotFoundException;

    UserDTO getFollowingCount(int userid) throws UserIdNotFoundException;
    UserDTO getFollowing(int userid) throws UserIdNotFoundException;
    /*Integer addUrlToRepository(UrlDTO urldto) throws UrlNotValidException;
    UrlDTO getUrlById(Integer id)  throws UrlIdNotFoundException;*/

}
