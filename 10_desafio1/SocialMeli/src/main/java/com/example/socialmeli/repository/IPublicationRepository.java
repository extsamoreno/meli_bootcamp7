package com.example.socialmeli.repository;

import com.example.socialmeli.model.Publication;

import java.util.List;

public interface IPublicationRepository {
    Publication addPublication(Publication obj);

    List<Publication> getPublications();

    List<Publication> getPublicationsPromo();
}
