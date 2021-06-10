package com.example.demo.project.repository;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.models.Publication;
import com.example.demo.project.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataRepository implements IDataRepository {

    private Hashtable<Integer, User> users = LoadUserDataBase();
    private Hashtable<Integer, Publication> publications = LoadPublicationDataBase();

    @Override
    public User getUserById(Integer id) {
        return users.get(id);
    }

    @Override
    public Publication getPublicationById(Integer id) {
        return publications.get(id);
    }

    @Override
    public void addPublication(Publication publication) throws DuplicatedPublicationIdException, UserIdNotFoundException {
        if (publications.containsKey(publication.getPost_id())) throw new DuplicatedPublicationIdException(publication.getPost_id());
        if (!users.containsKey(publication.getUser_id())) throw new UserIdNotFoundException(publication.getUser_id());
        publications.put(publication.getPost_id(), publication);
        users.get(publication.getUser_id()).getPublications().add(publication.getPost_id());
        persistPublicationDataBase();
        persistUserDataBase();
    }

    @Override
    public List<Publication> getFollowedPublications(List<Integer> users_id) {

        //GET USERS FROM FOLLOWING IDS
        List<User> seller_list = users_id
                .stream()
                .map(user_id-> getUserById(user_id))
                .collect(Collectors.toList());

        //GET PUBLICATION IDS FROM THOSE USERS
        List<Integer> publications_id = seller_list.stream().map(user -> user.getPublications()).flatMap(listContainer -> listContainer.stream()).collect(Collectors.toList());

        //GET PUBLICATIONS
        return getPublications(publications_id);
    }

    @Override
    public List<Publication> getPublications(List<Integer> publications) {

        //GET PUBLICATIONS
        List<Publication> publications_list = publications
                .stream()
                .map(user_id-> getPublicationById(user_id))
                .filter(publication -> publication.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList());

        return publications_list;
    }

    @Override
    public List<Publication> getPromoPublications(List<Integer> publications) {

        //GET PUBLICATIONS
        List<Publication> publications_list = publications
                .stream()
                .map(user_id-> getPublicationById(user_id))
                .filter(publication -> publication.getHas_promo())
                .collect(Collectors.toList());

        return publications_list;
    }

    private Hashtable<Integer,User> LoadUserDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> users_list = null;
        try {
            users_list = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Hashtable<Integer, User> users = new Hashtable<>();
        for (User user: users_list) {
            users.put(user.getId(), user);
        }

        return users;
    }

    private Hashtable<Integer, Publication> LoadPublicationDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/publications.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        TypeReference<List<Publication>> typeRef = new TypeReference<>() {};
        List<Publication> publications_list = null;
        try {
            publications_list = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Hashtable<Integer, Publication> publications = new Hashtable<>();
        for (Publication publication: publications_list) {
            publications.put(publication.getPost_id(), publication);
        }

        return publications;
    }

    public void persistPublicationDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/publications.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Publication> publications_list = new ArrayList<>();
        publications.forEach((k, v) -> publications_list.add(v));
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            objectMapper.writeValue(file, publications_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void persistUserDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<User> users_list = new ArrayList<>();
        users.forEach((k, v) -> users_list.add(v));
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            objectMapper.writeValue(file, users_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
