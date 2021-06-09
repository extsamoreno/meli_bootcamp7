package com.example.desafio_1.repository;

import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Seller;
import com.example.desafio_1.models.User;

public interface IUserRepository extends IRepository<User> {
    void followUser(Buyer userFollower, Seller userToFollow);

    void unfollowUser(Buyer userFollower, Seller userToFollow);
}
