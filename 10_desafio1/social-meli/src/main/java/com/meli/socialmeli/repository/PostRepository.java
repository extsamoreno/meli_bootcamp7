package com.meli.socialmeli.repository;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void insertPost(Post post) {
        Optional<Post> item = this.posts.stream().filter(i -> i.getPostId().equals(post.getPostId()) && i.getUserId().equals(post.getUserId())).findFirst();

        if(item.isEmpty()) {
            this.posts.add(post);
        }
    }

    @Override
    public List<Post> getFollowedPosts(List<User> followed, String order) {
        List<Post> followedPosts = new ArrayList<>();

        for (User u : followed) {
            followedPosts.addAll(getPostsByUser(u.getUserId()));
        }

        if(order != null && order.equals("date_asc")) {
            followedPosts.sort(Comparator.comparing(Post::getDate));
        } else {
            followedPosts.sort((d1, d2) -> d2.getDate().compareTo(d1.getDate()));
        }

        return followedPosts;
    }

    private List<Post> getPostsByUser(Integer userId) {
        return this.posts.stream()
                .filter(i -> i.getUserId().equals(userId))
                .filter(i -> i.getDate().after(getDateBeforeTwoWeeks()))
                .collect(Collectors.toList());
    }

    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }

    private Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
