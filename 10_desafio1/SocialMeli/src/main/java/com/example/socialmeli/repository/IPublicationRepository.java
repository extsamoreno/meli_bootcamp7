package com.example.socialmeli.repository;

import com.example.socialmeli.model.Publication;

import java.util.List;

public interface IPublicationRepository {
    Publication addPost (Publication obj);
    List<Publication> getPosts();
}
