package com.reto1.demo.Model;

import lombok.Data;


public interface IUser {

    void followPages(IUser iuser);
    void addFollower(IUser follower);
    void unFollowPages(IUser iuser);
    void removeFollower(IUser follower);
}
