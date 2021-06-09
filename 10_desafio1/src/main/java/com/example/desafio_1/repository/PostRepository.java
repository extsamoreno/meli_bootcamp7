package com.example.desafio_1.repository;

import com.example.desafio_1.models.Post;
import com.example.desafio_1.service.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostRepository implements IPostRepository {
    private HashMap<Integer, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<>();
    }

    @Override
    public Post getById(int id) {
        return posts.get(id);
    }

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(posts.values());
    }

    @Override
    public void add(Post post) {
        if(post.getId() == 0) {
            int newId = this.posts.size() + 1;
            post.setId(newId);
        }
        this.posts.put(post.getId(), post);
    }

    @Override
    public List<Post> getAllPostsBeforeTwoWeeksFromSellerId(int sellerId) {
        return posts.values()
                .stream()
                .filter(post -> post.getUserId() == sellerId)
                .filter(post -> post.getCreatedDate().after(Utils.getDateBeforeTwoWeeks()))
                .collect(Collectors.toList());
    }
}
