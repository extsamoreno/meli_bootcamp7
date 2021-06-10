package com.meli.socialmeli.repository.post;

import com.meli.socialmeli.exception.InvalidDateException;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.ProductAlreadyPostedException;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.post.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {
    private final List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void insertPost(Post post) throws PostAlreadyInsertedException, ProductAlreadyPostedException, InvalidDateException {
        //Check if the post is not already inserted by the user
        Optional<Post> item = this.posts.stream().filter(i -> i.getPostId().equals(post.getPostId()) && i.getUserId().equals(post.getUserId())).findFirst();

        if(item.isPresent())
            throw new PostAlreadyInsertedException(post.getUserId(),post.getPostId());

        //Check if the product is not already posted by the user
        item = this.posts.stream().filter(i -> i.getDetail().getProductId().equals(post.getDetail().getProductId()) && i.getUserId().equals(post.getUserId())).findFirst();

        if(item.isPresent())
            throw new ProductAlreadyPostedException(post.getUserId(),post.getDetail().getProductId());

        if(!validDate(post.getDate()))
            throw new InvalidDateException();

        this.posts.add(post);
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

    @Override
    public List<Post> getPromoPosts(Integer userId) {
        return this.posts.stream().filter(i -> i.getUserId().equals(userId)).filter(Post::isHasPromo).collect(Collectors.toList());
    }

    private List<Post> getPostsByUser(Integer userId) {
        return this.posts.stream().filter(i -> i.getUserId().equals(userId)).filter(i -> i.getDate().after(getDateBeforeTwoWeeks())).collect(Collectors.toList());
    }

    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }

    private boolean validDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        return !calendar.getTime().before(date);
    }
}
