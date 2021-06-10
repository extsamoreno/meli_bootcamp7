package com.example.desafio1.repositories;

import com.example.desafio1.models.Post;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepository {
    void addPost(Post post);
    List<Post> getPost(int userId, LocalDate dateFrom, LocalDate dateTo);
    List<Post> getPromoPost(int userId);
}
