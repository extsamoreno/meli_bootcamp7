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
        Post checkPost = this.posts.stream()
                .filter(p -> p.getId_post() == post.getId_post())
                .findAny().orElse(null);

        if (checkPost != null) {
            throw new PostIdAlreadyExistException(post.getId_post());
        } else {
            this.posts.add(post.getId_post(), post);
        }
    }

    @Override
    public List<Post> getFollowedPosts(List<User> followed, String order) {
        List<Post> followedPosts = new ArrayList<>();

        for (User u : followed) {
            followedPosts.addAll(getPosts(u.getUserId()));
        }

        if (order != null && order.equals("date_asc"))
            followedPosts.sort(Comparator.comparing(Post::getDate));

        if (order != null && order.equals("date_desc"))
            followedPosts.sort(Comparator.comparing(Post::getDate).reversed());

        return followedPosts;
    }

    private List<Post> getPosts(Integer userId) {
        return this.posts.stream()
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
