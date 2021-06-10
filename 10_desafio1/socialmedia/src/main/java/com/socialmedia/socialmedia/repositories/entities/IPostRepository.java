package com.socialmedia.socialmedia.repositories.entities;

import com.socialmedia.socialmedia.exceptions.ObjectNotFoundException;
import com.socialmedia.socialmedia.repositories.IRepository;

import java.util.List;

public interface IPostRepository extends IRepository<Post> {
    Post getByPostId(int postId) throws ObjectNotFoundException;
    List<Post> getByUserForTwoWeeksId(int userId);
}
