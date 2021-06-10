package com.example.demo.project.repository;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.models.Publication;
import com.example.demo.project.models.User;

import java.util.List;

public interface IDataRepository {

    User getUserById(Integer id) throws UserIdNotFoundException;
    void addPublication(Publication publication) throws DuplicatedPublicationIdException, UserIdNotFoundException;

    void persistPublicationDataBase();
    void persistUserDataBase();

    Publication getPublicationById(Integer id);
    List<Publication> getFollowedPublications(List<Integer> users_id);
    List<Publication> getPublications(List<Integer> users_id);
    List<Publication> getPromoPublications(List<Integer> users_id);
}