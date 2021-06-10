package com.example.demo.services;


import com.example.demo.entities.User;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.*;
import com.example.demo.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public void addFollow(int userId, int sellerId) throws Exception {

        User user = userRepository.getById(userId);
        User seller = userRepository.getById(sellerId);

        if (user == null) {
            throw new NotFoundException("User not exist");
        }
        if (seller == null) {
            throw new NotFoundException("Seller not exist");
        }

        if (seller.getFollowers().contains(user)) {
            throw new BadRequestException("User already following this seller");
        }
        userRepository.getById(sellerId).getFollowers().add(userRepository.getById(userId));
        userRepository.saveUsers();

    }

    public ResponseCountFollowersDTO countFollowers(int sellerId) throws Exception {

        User user = userRepository.getById(sellerId);
        if (user == null) {
            throw new NotFoundException("User not exists");
        }

        return new ResponseCountFollowersDTO(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers() == null ? 0 : user.getFollowers().size()
        );
    }

    public ResponseListFollowersDTO listFollowers(int sellerId, String order) throws Exception {

        User seller = userRepository.getById(sellerId);
        if (seller == null) {
            throw new NotFoundException("User not exists");
        }
        if (seller.getFollowers() == null) {
            throw new NotFoundException("Seller has no followers");
        }

        return new ResponseListFollowersDTO(
                seller.getUserId(),
                seller.getUserName(),
                userRepository.sortByCriteria(
                        Mappers.toUserDTOlist(seller.getFollowers()),
                        order == null ? "date_desc" : order)

        );
    }

    public ResponseListSellerDTO listSellers(int userId, String order) throws Exception {

        User user = userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not exists");
        }

        List<User> sellersByUser = userRepository.getSellersFollowedByUser(user);

        return new ResponseListSellerDTO(
                user.getUserId(),
                user.getUserName(),
                userRepository.sortByCriteria(
                        Mappers.toUserDTOlist(sellersByUser),
                        order == null ? "date_desc" : order)

        );
    }

    public void unFolLowSeller(int idUser, int sellerId) throws Exception {

        User user = userRepository.getById(idUser);
        User seller = userRepository.getById(sellerId);

        if (user == null) {
            throw new NotFoundException("User not exist");
        }
        if (seller == null) {
            throw new NotFoundException("Seller not exist");
        }
        userRepository.unFollowSeller(user, seller);
        userRepository.saveUsers();
    }
}
