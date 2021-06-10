package com.example.socialmeli.repository;

import com.example.socialmeli.model.Publication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements IPublicationRepository {
    List<Publication> publications = new ArrayList<>();
    int cont = 1;

    @Override
    public Publication addPublication(Publication obj) {
        obj.setId_post(cont++);
        publications.add(obj);
        return obj;
    }

    @Override
    public List<Publication> getPublications() {
        return publications.stream().takeWhile(x -> !x.isHasPromo()).collect(Collectors.toList());
    }

    @Override
    public List<Publication> getPublicationsPromo() {
        return publications.stream().takeWhile(x -> x.isHasPromo()).collect(Collectors.toList());
    }
}
