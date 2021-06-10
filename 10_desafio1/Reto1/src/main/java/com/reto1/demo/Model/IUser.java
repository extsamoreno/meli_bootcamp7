package com.reto1.demo.Model;


public interface IUser {

    void followPages(User page);
    void addFollower(User follower);
    void unFollowPages(IUser iuser);
    void removeFollower(IUser follower);
}
