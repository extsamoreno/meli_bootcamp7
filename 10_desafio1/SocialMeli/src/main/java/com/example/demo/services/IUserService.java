package com.example.demo.services;

import com.example.demo.DTO.ResponseCountFollowersDTO;
import com.example.demo.DTO.ResponseListFollowersDTO;
import com.example.demo.DTO.ResponseListSellerDTO;

public interface IUserService {

    public void addFollow(int userId, int sellerId) throws Exception;
    public ResponseCountFollowersDTO countFollowers(int sellerId) throws Exception;
    public ResponseListFollowersDTO listFollowers(int sellerId, String order) throws Exception;
    public void unFolLowSeller(int idUser, int sellerId) throws Exception;
    public ResponseListSellerDTO listSellers(int userId, String order) throws Exception;
}
