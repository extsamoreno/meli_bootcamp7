package com.example.desafio1.repositories;

import com.example.desafio1.models.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository{
    List<Post> postList = new ArrayList<>();

    @Override
    public void addPost(Post post) {
        postList.add(post);
    }

    @Override
    public List<Post> getPost(int userId, LocalDate dateFrom, LocalDate dateTo) {
        return postList.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(post -> post.getDate().isAfter(dateFrom) && post.getDate().isBefore(dateTo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromoPost(int userId) {
        return postList.stream()
                .filter(post -> post.getUserId() == userId)
                .filter(Post::isHasPromo)
                .collect(Collectors.toList());
    }
}
