package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts = new ArrayList<>();

    @Override
    public void addNewPost(Post post) throws PostIdAlreadyExistException {
        Post checkPost = posts.stream()
                .filter(p -> p.getId_post() == post.getId_post())
                .findAny().orElse(null);
        if (checkPost != null) {
            throw new PostIdAlreadyExistException(post.getId_post());
        } else {
            posts.add(post);
        }
    }

    @Override
    public List<Post> getFollowedPosts(List<User> followed) {
        List<Post> followedPosts = new ArrayList<>();

        for (User u : followed) {
            followedPosts.addAll(getPosts(u.getUserId()));
        }

        return followedPosts;
    }

    @Override
    public int getPromoProductsCount(int userId) {
        return (int) posts.stream()
                .filter(p -> p.getUserId() == (userId) && p.isHasPromo())
                .count();
    }

    @Override
    public List<Post> getPromoPostsList(int userId) {
        return posts.stream()
                .filter(p -> p.getUserId() == userId && p.isHasPromo())
                .collect(Collectors.toList());
    }

    private List<Post> getPosts(Integer userId) {
        return posts.stream()
                .filter(i -> i.getUserId() == (userId))
                .filter(i -> i.getDate().after(getDateBefore15days()))
                .collect(Collectors.toList());
    }

    private Date getDateBefore15days() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }
}
