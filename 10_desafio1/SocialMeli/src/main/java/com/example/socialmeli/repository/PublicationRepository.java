package com.example.socialmeli.repository;

import com.example.socialmeli.model.Publication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublicationRepository implements IPublicationRepository {
    List<Publication> posts = new ArrayList<>();
    int cont = 1;
    @Override
    public Publication addPost(Publication obj) {
        obj.setId_post(cont++);
        posts.add(obj);
        return obj;
    }
    @Override
    public List<Publication> getPosts() {
        return posts;
    }
}
