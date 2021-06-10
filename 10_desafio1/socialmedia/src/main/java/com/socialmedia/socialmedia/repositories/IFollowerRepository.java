package com.socialmedia.socialmedia.repositories;

import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.repositories.entities.Follower;

import java.util.List;

public interface IFollowerRepository extends IRepository<Follower> {
    List<Follower> getFollowersByUserId(int userId) throws ObjectNotFoundException;
    List<Follower> getFollowersByFollowerId(int followerId) throws ObjectNotFoundException;
    Follower getFollowerByUserIdAndFollowerId(int userId, int followerId);
}
