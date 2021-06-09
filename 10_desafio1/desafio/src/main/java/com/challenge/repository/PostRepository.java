package com.challenge.repository;

import com.challenge.entity.Post;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface PostRepository {

    void addNewProduct(Post post) throws PostIdAlreadyExistsException, IOException;
    List<Post> getRecentPosts(List<Integer> followedIds, LocalDate since);
    Integer getPromoPostCount(Integer userId);
}
